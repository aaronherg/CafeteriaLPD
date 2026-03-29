package com.aarondevs.cafeterialpd.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Screen {

    // General
    @Serializable
    data object LoginScreen : Screen()
    @Serializable
    data object InformacionScreen : Screen()


    // Administrador
    @Serializable
    data object AdministradorInicioScreen : Screen()
    @Serializable
    data object AdministradorVentasScreen : Screen()
    @Serializable
    data object AdministradorInventarioScreen : Screen()
    @Serializable
    data object AdministradorConfiguracionScreen : Screen()
    @Serializable
    data object AdministradorPerfilScreen : Screen()
    @Serializable
    data object AdministradorHistorialVentaScreen : Screen()
    @Serializable
    data object AdministradorVistaPreviaVentaScreen : Screen()
    @Serializable
    data object AdministradorConfiguracionAreasScreen : Screen()
    @Serializable
    data object AdministradorConfiguracionAreaControlScreen : Screen()
    @Serializable
    data object AdministradorConfiguracionGeneralScreen : Screen()
    @Serializable
    data object AdministradorConfiguracionImpresoraScreen : Screen()
    @Serializable
    data object AdministradorConfiguracionUsuarioScreen : Screen()
    @Serializable
    data object AdministradorConfiguracionUsuarioControlScreen : Screen()
    @Serializable
    data object AdministradorInventarioProductoControlScreen : Screen()
    @Serializable
    data object AdministradorInventarioCategoriaScreen : Screen()


    // Cajero
    @Serializable
    data object CajeroInicioScreen : Screen()
    @Serializable
    data object CajeroVentasScreen : Screen()
    @Serializable
    data object CajeroPerfilScreen : Screen()


    // Pantalla
    @Serializable
    data object PantallaOrdenesScreen : Screen()


}