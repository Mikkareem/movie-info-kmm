//
//  DiscoverMoviesViewModel.swift
//  iosApp
//
//  Created by Irsath Kareem on 06/11/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension ContentView {
    @MainActor class DiscoverMoviesViewModel: ObservableObject {
        @Published private(set) var movies: [Movie] = []
        @Published private(set) var isLoading: Bool = false
        @Published private(set) var errorMessage: String = ""
        
        private var currentPage = 1
        
        private func processServiceResult(result serviceResult: ServiceResult<NSArray>?) {
            if let serviceResult = serviceResult {
                if let data = serviceResult.data {
                    let movies = data as! [Movie]
                    self.movies = self.movies + movies
                    self.currentPage += 1
                    self.isLoading = false
                } else if let errorMessage = serviceResult.errorMessage {
                    print(errorMessage)
                    self.errorMessage = errorMessage
                    self.isLoading = false
                }
            }
        }
        
        private func discoverMovies(page: Int32) async throws -> ServiceResult<NSArray> {
            return await withCheckedContinuation { continuation in
                KoinDependencyHelper().getMovieInfoRepository()
                    .discoverMovies(
                        page: page,
                        completionHandler: { serviceResult, error in
                            if let serviceResult = serviceResult {
                                continuation.resume(returning: serviceResult)
                            } else if let error = error {
                                continuation.resume(throwing: error as! Never)
                            }
                        }
                    )
            }
        }
        
        func discoverMovies() async {
            if isLoading {
                return
            }
            
            do {
                isLoading = true
                let serviceResult = try await discoverMovies(page: Int32(currentPage))
                processServiceResult(result: serviceResult)
            } catch {
                print("Unknown Error")
            }
        }
    }
}

