import SwiftUI
import shared

@main
struct iOSApp: App {
    
    @UIApplicationDelegateAdaptor var delegate: AppDelegate
    
    var body: some Scene {
        
        WindowGroup {
            ContentView()
        }
    }
}
