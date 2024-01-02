//
//  AppDelegate.swift
//  iosApp
//
//  Created by Lee on 12/31/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import UIKit
import shared

class AppDelegate : NSObject, UIApplicationDelegate {
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]? = nil
    ) -> Bool {

        // plants insert -> 들어갔는지 확인
        PlantFeatureModule().providePlantRepository().insertOrReplacePlants(filePath: "json/plants.json") { _ in
            PlantFeatureModule().providePlantRepository().getAllPlants(){ listPlants, error in
                print(listPlants)
            }
        }

        return true
    }
}
