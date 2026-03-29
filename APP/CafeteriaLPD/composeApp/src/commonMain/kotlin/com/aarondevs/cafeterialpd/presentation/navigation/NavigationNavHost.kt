package com.aarondevs.cafeterialpd.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aarondevs.cafeterialpd.presentation.screens.admin.configuracion.AdministradorConfiguracionScreen
import com.aarondevs.cafeterialpd.presentation.screens.admin.configuracion.areas.AdministradorConfiguracionAreaControlScreen
import com.aarondevs.cafeterialpd.presentation.screens.admin.configuracion.areas.AdministradorConfiguracionAreasScreen
import com.aarondevs.cafeterialpd.presentation.screens.admin.configuracion.general.AdministradorConfiguracionGeneralScreen
import com.aarondevs.cafeterialpd.presentation.screens.admin.configuracion.impresoras.AdministradorConfiguracionImpresoraScreen
import com.aarondevs.cafeterialpd.presentation.screens.admin.configuracion.usuarios.AdministradorConfiguracionUsuarioControlScreen
import com.aarondevs.cafeterialpd.presentation.screens.admin.configuracion.usuarios.AdministradorConfiguracionUsuarioScreen
import com.aarondevs.cafeterialpd.presentation.screens.admin.inicio.AdministradorInicioScreen
import com.aarondevs.cafeterialpd.presentation.screens.admin.inventario.AdministradorInventarioScreen
import com.aarondevs.cafeterialpd.presentation.screens.admin.inventario.categorias.AdministradorInventarioCategoriaScreen
import com.aarondevs.cafeterialpd.presentation.screens.admin.inventario.productos.AdministradorInventarioProductoControlScreen
import com.aarondevs.cafeterialpd.presentation.screens.admin.perfil.AdministradorPerfilScreen
import com.aarondevs.cafeterialpd.presentation.screens.admin.ventas.historial.AdministradorHistorialVentaScreen
import com.aarondevs.cafeterialpd.presentation.screens.admin.ventas.AdministradorVentasScreen
import com.aarondevs.cafeterialpd.presentation.screens.admin.ventas.historial.AdministradorVistaPreviaVentaScreen
import com.aarondevs.cafeterialpd.presentation.screens.general.login.LoginScreen


@Composable
fun NavigationNavHost(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = Screen.LoginScreen) {

        // General
        composable<Screen.LoginScreen> {
            LoginScreen(
                onIniciarSesionAdministrador = {
                    navHostController.navigate(Screen.AdministradorVentasScreen)
                },
                onIniciarSesionCajero = {
                    navHostController.navigate(Screen.CajeroVentasScreen)
                },
                onIniciarSesionPantalla = {
                    navHostController.navigate(Screen.PantallaOrdenesScreen)
                }
            )
        }

        // Administrador

        composable<Screen.AdministradorVentasScreen> {
            AdministradorVentasScreen(
                onInicio = {
                    navHostController.navigate(Screen.AdministradorInicioScreen)
                },
                onInventario = {
                    navHostController.navigate(Screen.AdministradorInventarioScreen)
                },
                onConfiguracion = {
                    navHostController.navigate(Screen.AdministradorConfiguracionScreen)
                },
                onPerfil = {
                    navHostController.navigate(Screen.AdministradorPerfilScreen)
                },
                onHistorialVenta = {
                    navHostController.navigate(Screen.AdministradorHistorialVentaScreen)
                },
            )
        }

        composable<Screen.AdministradorInicioScreen> {
            AdministradorInicioScreen(
                onVenta = {
                    navHostController.navigate(Screen.AdministradorVentasScreen)
                },
                onInventario = {
                    navHostController.navigate(Screen.AdministradorInventarioScreen)
                },
                onConfiguracion = {
                    navHostController.navigate(Screen.AdministradorConfiguracionScreen)
                },
                onPerfil = {
                    navHostController.navigate(Screen.AdministradorPerfilScreen)
                }
            )
        }

        composable<Screen.AdministradorInventarioScreen> {
            AdministradorInventarioScreen(
                onVenta = {
                        navHostController.navigate(Screen.AdministradorVentasScreen)
                },
                onInicio = {
                    navHostController.navigate(Screen.AdministradorInicioScreen)
                },
                onConfiguracion = {
                    navHostController.navigate(Screen.AdministradorConfiguracionScreen)
                },
                onPerfil = {
                    navHostController.navigate(Screen.AdministradorPerfilScreen)
                },
                onNuevoProducto = {
                    navHostController.navigate(Screen.AdministradorInventarioProductoControlScreen)
                },
                onEditarProducto = {
                    navHostController.navigate(Screen.AdministradorInventarioProductoControlScreen)
                },
                onCategoria = {
                    navHostController.navigate(Screen.AdministradorInventarioCategoriaScreen)
                }
            )
        }

        composable<Screen.AdministradorPerfilScreen> {
            AdministradorPerfilScreen(
                onInicio = {
                    navHostController.navigate(Screen.AdministradorInicioScreen)
                },
                onInventario = {
                    navHostController.navigate(Screen.AdministradorInventarioScreen)
                },
                onVenta = {
                    navHostController.navigate(Screen.AdministradorVentasScreen)
                },
                onConfiguracion = {
                    navHostController.navigate(Screen.AdministradorConfiguracionScreen)
                },
                onEditarUsuario = {
                    // PROXIMAMENTE...
                },
                onCerrarSesion = {
                    navHostController.navigate(Screen.LoginScreen)
                }
            )
        }


        composable<Screen.AdministradorConfiguracionScreen> {
            AdministradorConfiguracionScreen(
                onInicio = {
                    navHostController.navigate(Screen.AdministradorInicioScreen)
                },
                onInventario = {
                    navHostController.navigate(Screen.AdministradorInventarioScreen)
                },
                onVenta = {
                    navHostController.navigate(Screen.AdministradorVentasScreen)
                },
                onPerfil = {
                    navHostController.navigate(Screen.AdministradorPerfilScreen)
                },
                onAreas = {
                    navHostController.navigate(Screen.AdministradorConfiguracionAreasScreen)
                },
                onGeneral = {
                    navHostController.navigate(Screen.AdministradorConfiguracionGeneralScreen)
                },
                onImpresoras = {
                    navHostController.navigate(Screen.AdministradorConfiguracionImpresoraScreen)
                },
                onUsuarios = {
                    navHostController.navigate(Screen.AdministradorConfiguracionUsuarioScreen)
                }
            )
        }

        composable<Screen.AdministradorHistorialVentaScreen> {
            AdministradorHistorialVentaScreen(
                onRetroceder = {
                    navHostController.popBackStack()
                },
                onInformacion = {
                    navHostController.navigate(Screen.InformacionScreen)
                },
                onVistaPrevia = {
                    navHostController.navigate(Screen.AdministradorVistaPreviaVentaScreen)
                }
            )
        }

        composable<Screen.AdministradorVistaPreviaVentaScreen> {
            AdministradorVistaPreviaVentaScreen(
                onRetroceder = {
                    navHostController.popBackStack()
                },
                onInformacion = {
                    navHostController.navigate(Screen.InformacionScreen)
                }
            )
        }


        composable<Screen.AdministradorConfiguracionAreasScreen> {
            AdministradorConfiguracionAreasScreen(
                onRetroceder = {
                    navHostController.popBackStack()
                },
                onInformacion = {
                    navHostController.navigate(Screen.InformacionScreen)
                },
                onNuevaArea= {
                    navHostController.navigate(Screen.AdministradorConfiguracionAreaControlScreen)
                },
                onEditarArea = {
                    navHostController.navigate(Screen.AdministradorConfiguracionAreaControlScreen)
                }
            )
        }

        composable<Screen.AdministradorConfiguracionAreaControlScreen> {
            AdministradorConfiguracionAreaControlScreen(
                onRetroceder = {
                    navHostController.popBackStack()
                },
                onInformacion = {
                    navHostController.navigate(Screen.InformacionScreen)
                }
            )
        }

        composable<Screen.AdministradorConfiguracionGeneralScreen> {
            AdministradorConfiguracionGeneralScreen(
                onRetroceder = {
                    navHostController.popBackStack()
                },
                onInformacion = {
                    navHostController.navigate(Screen.InformacionScreen)
                }
            )
        }

        composable<Screen.AdministradorConfiguracionImpresoraScreen> {
            AdministradorConfiguracionImpresoraScreen(
                onRetroceder = {
                    navHostController.popBackStack()
                },
                onInformacion = {
                    navHostController.navigate(Screen.InformacionScreen)
                }
            )
        }

        composable<Screen.AdministradorConfiguracionUsuarioScreen> {
            AdministradorConfiguracionUsuarioScreen(
                onRetroceder = {
                    navHostController.popBackStack()
                },
                onInformacion = {
                    navHostController.navigate(Screen.InformacionScreen)
                },
                onNuevoUsuario = {
                    navHostController.navigate(Screen.AdministradorConfiguracionUsuarioControlScreen)
                },
                onEditarUsuario = {
                    navHostController.navigate(Screen.AdministradorConfiguracionUsuarioControlScreen)
                }
            )
        }

        composable<Screen.AdministradorConfiguracionUsuarioControlScreen> {
            AdministradorConfiguracionUsuarioControlScreen(
                onRetroceder = {
                    navHostController.popBackStack()
                },
                onInformacion = {
                    navHostController.navigate(Screen.InformacionScreen)
                }
            )
        }

        composable<Screen.AdministradorInventarioProductoControlScreen> {
            AdministradorInventarioProductoControlScreen(
                onRetroceder = {
                    navHostController.popBackStack()
                },
                onInformacion = {
                    navHostController.navigate(Screen.InformacionScreen)
                }
            )
        }

        composable<Screen.AdministradorInventarioCategoriaScreen> {
            AdministradorInventarioCategoriaScreen(
                onRetroceder = {
                    navHostController.popBackStack()
                },
                onInformacion = {
                    navHostController.navigate(Screen.InformacionScreen)
                }
            )
        }




    }
}