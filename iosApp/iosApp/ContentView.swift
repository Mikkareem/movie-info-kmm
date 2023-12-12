import SwiftUI
import shared

struct ContentView: View {
    @StateObject var discoverMoviesViewModel = DiscoverMoviesViewModel()
    
    let gridItems: [GridItem] = Array(repeating: GridItem(.flexible(), spacing: 16), count: 2)

    var body: some View {
        NavigationStack {
            ZStack {
                Color.orange.ignoresSafeArea()
                
                if discoverMoviesViewModel.isLoading {
                    ProgressView()
                } else {
                    ScrollView {
                        LazyVGrid(columns: gridItems, spacing: 12) {
                            ForEach(discoverMoviesViewModel.movies, id: \.id) { movie in
                                NavigationLink(value: movie) {
                                    MovieGridItem(movie: movie)
                                        .task {
                                            if movie == discoverMoviesViewModel.movies.last {
                                                await discoverMoviesViewModel.discoverMovies()
                                            }
                                        }
                                }
                                .buttonStyle(PlainButtonStyle())
                            }
                        }
                        .navigationDestination(for: Movie.self) { movie in
                            Text(movie.title)
                                .navigationTitle(movie.title)
                        }
                    }
                }
            }
            .progressViewStyle(.circular)
            .navigationTitle("Movies")
        }
        .task {
            await discoverMoviesViewModel.discoverMovies()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

protocol Findable {}
protocol Errorable {}

extension ServiceResult: Findable {}

func temporary<C, D>(_ first: C, _ second: D?) where C: Findable, D: Sendable {
    
}

func temp() {
    temporary(ServiceResult<KotlinInt>(data: 32, errorMessage: ""), URLError(URLError.Code.badURL))
}
