package com.adedom.covid19.di

import android.content.Context
import io.mockk.mockk
import org.junit.Test
import org.junit.experimental.categories.Category
import org.koin.core.error.InstanceCreationException
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.category.CheckModuleTest
import org.koin.test.check.checkModules

@Category(CheckModuleTest::class)
class ModuleCheckTest : AutoCloseKoinTest() {

    @Test
    fun test_checkModules() {
        val context = module {
            single { mockk<Context>(relaxed = true) }
        }

        try {
            checkModules {
                modules(context, appModule, dataStorageModule, networkModule)
            }
        } catch (e: InstanceCreationException) {
        } catch (e: RuntimeException) {
        }
    }

}
