import SwiftUI
import shared

@main
struct iOSApp: App {
    
    init() {
        KoinHelperKt.doStartKoin()
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
