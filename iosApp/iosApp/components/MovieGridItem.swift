//
//  MovieGridItem.swift
//  iosApp
//
//  Created by Irsath Kareem on 06/11/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MovieGridItem: View {
    
    let movie: Movie
    
    var body: some View {
        VStack(alignment: .leading, spacing: 12) {
            ZStack {
                AsyncImage(url: URL(string: movie.imageUrl)) { image in
                    image.resizable()
                } placeholder: {
                    Color.gray
                }
            }
            .frame(maxWidth: .infinity, idealHeight: .infinity)
            
            Text(movie.title)
        }
        .frame(maxWidth: /*@START_MENU_TOKEN@*/.infinity/*@END_MENU_TOKEN@*/, maxHeight: 260)
        .clipShape(RoundedRectangle(cornerRadius: 16))
    }
}

#Preview {
    MovieGridItem(movie: Movie(adult: false, id: 23, originalLanguage: "English", originalTitle: "Billa", overview: "Description", popularity: 34.66, imageUrl: "https://image.tmdb.org/t/p/w500/4np8KzfT7XHgwQT5sJTRogqIn0s.jpg", releaseDate: "fff", title: "ttt", voteAverage: 45.7, voteCount: 5908))
}
