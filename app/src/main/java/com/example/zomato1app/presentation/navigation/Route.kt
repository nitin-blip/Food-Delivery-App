package com.example.zomato1app.presentation.navigation



import kotlinx.serialization.Serializable

sealed class SubNavigation{

    @Serializable
    object LoginSingUpScreen : SubNavigation()
    @Serializable
    object MainHomeScreen : SubNavigation()

}

sealed class Routes{

    @Serializable
    object LoginScreen : Routes()

    @Serializable
    object SingUpScreen : Routes()

    @Serializable
    object DeliveryScreen : Routes()

    @Serializable
    object QuickScreen : Routes()

    @Serializable
    object DiningScreen : Routes()

    @Serializable
    object ProfileScreen : Routes()

    @Serializable
    object ParticularCardScreen : Routes()

    @Serializable
    object FinalCheckoutScreen : Routes()
    @Serializable
    object SearchBarScreen : Routes()

}
