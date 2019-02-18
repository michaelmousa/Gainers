package com.treehouse.gainers.retrofit

import com.treehouse.gainers.network.popServices
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent {
    fun popService(): popServices
}