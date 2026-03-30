package com.aarondevs.cafeterialpd.librery

import androidx.compose.ui.graphics.Color


object ColoresCategorias {

    val lista = listOf(
        Color(0xFFF87171), Color(0xFFEF4444), Color(0xFFDC2626), Color(0xFFB91C1C), Color(0xFFFCA5A5),
        Color(0xFFF472B6), Color(0xFFEC4899), Color(0xFFDB2777), Color(0xFFBE185D), Color(0xFFF9A8D4),
        Color(0xFFC084FC), Color(0xFFA855F7), Color(0xFF9333EA), Color(0xFF7E22CE), Color(0xFFD8B4FE),
        Color(0xFF818CF8), Color(0xFF6366F1), Color(0xFF4F46E5), Color(0xFF4338CA), Color(0xFFC7D2FE),
        Color(0xFF60A5FA), Color(0xFF3B82F6), Color(0xFF2563EB), Color(0xFF1D4ED8), Color(0xFF93C5FD),
        Color(0xFF38BDF8), Color(0xFF0EA5E9), Color(0xFF0284C7), Color(0xFF0369A1), Color(0xFF7DD3FC),
        Color(0xFF22D3EE), Color(0xFF06B6D4), Color(0xFF0891B2), Color(0xFF0E7490), Color(0xFF67E8F9),
        Color(0xFF2DD4BF), Color(0xFF14B8A6), Color(0xFF0D9488), Color(0xFF0F766E), Color(0xFF5EEAD4),
        Color(0xFF34D399), Color(0xFF10B981), Color(0xFF059669), Color(0xFF047857), Color(0xFF6EE7B7),
        Color(0xFF4ADE80), Color(0xFF22C55E), Color(0xFF16A34A), Color(0xFF15803D), Color(0xFF86EFAC),
        Color(0xFFA3E635), Color(0xFF84CC16), Color(0xFF65A30D), Color(0xFF4D7C0F), Color(0xFFBEF264),
        Color(0xFFFACC15), Color(0xFFEAB308), Color(0xFFCA8A04), Color(0xFFA16207), Color(0xFFFDE047),
        Color(0xFFFBBF24), Color(0xFFF59E0B), Color(0xFFD97706), Color(0xFFB45309), Color(0xFFFCD34D),
        Color(0xFFFB923C), Color(0xFFF97316), Color(0xFFEA580C), Color(0xFFC2410C), Color(0xFFFDBA74),
        Color(0xFFFCA5A5), Color(0xFFFECACA), Color(0xFFFDE68A), Color(0xFFFEF3C7), Color(0xFFDCFCE7),
        Color(0xFFD1FAE5), Color(0xFFE0F2FE), Color(0xFFBAE6FD), Color(0xFFEDE9FE), Color(0xFFDDD6FE),
        Color(0xFFF3E8FF), Color(0xFFFCE7F3), Color(0xFFFCE7F3), Color(0xFFE2E8F0), Color(0xFFCBD5F5),
        Color(0xFF94A3B8), Color(0xFF64748B), Color(0xFF475569), Color(0xFF334155), Color(0xFF1E293B)
    )
}


object Permisos {

    // Configuracion
    const val AGREGAR_CONFIGURACION = "agregar_configuracion"
    const val EDITAR_CONFIGURACION = "editar_configuracion"
    const val ELIMINAR_CONFIGURACION = "eliminar_configuracion"
    const val BUSCAR_CONFIGURACION = "buscar_configuracion"
    const val LISTAR_CONFIGURACIONES = "listar_configuraciones"

    // Usuarios
    const val AGREGAR_USUARIO = "agregar_usuario"
    const val EDITAR_USUARIO = "editar_usuario"
    const val ELIMINAR_USUARIO = "eliminar_usuario"
    const val BUSCAR_USUARIO = "buscar_usuario"
    const val LISTAR_USUARIOS = "listar_usuarios"
    const val CERRAR_SESION = "cerrar_sesion"
    const val LOGIN = "login"
    const val VERIFICAR_SESION = "verificar_sesion"

    // Roles
    const val AGREGAR_ROL = "agregar_rol"
    const val EDITAR_ROL = "editar_rol"
    const val ELIMINAR_ROL = "eliminar_rol"
    const val BUSCAR_ROL = "buscar_rol"
    const val LISTAR_ROLES = "listar_roles"

    // Categorías
    const val AGREGAR_CATEGORIA = "agregar_categoria"
    const val EDITAR_CATEGORIA = "editar_categoria"
    const val ELIMINAR_CATEGORIA = "eliminar_categoria"
    const val BUSCAR_CATEGORIA = "buscar_categoria"
    const val LISTAR_CATEGORIAS = "listar_categorias"

    // Áreas
    const val AGREGAR_AREA = "agregar_area"
    const val EDITAR_AREA = "editar_area"
    const val ELIMINAR_AREA = "eliminar_area"
    const val BUSCAR_AREA = "buscar_area"
    const val LISTAR_AREAS = "listar_areas"

    // Ventas
    const val AGREGAR_VENTA = "agregar_venta"
    const val EDITAR_VENTA = "editar_venta"
    const val ELIMINAR_VENTA = "eliminar_venta"
    const val BUSCAR_VENTA = "buscar_venta"
    const val LISTAR_VENTAS = "listar_ventas"

    // Productos
    const val AGREGAR_PRODUCTO = "agregar_producto"
    const val EDITAR_PRODUCTO = "editar_producto"
    const val ELIMINAR_PRODUCTO = "eliminar_producto"
    const val BUSCAR_PRODUCTO = "buscar_producto"
    const val LISTAR_PRODUCTOS = "listar_productos"

    // Clientes
    const val AGREGAR_CLIENTE = "agregar_cliente"
    const val EDITAR_CLIENTE = "editar_cliente"
    const val ELIMINAR_CLIENTE = "eliminar_cliente"
    const val BUSCAR_CLIENTE = "buscar_cliente"
    const val LISTAR_CLIENTES = "listar_clientes"
}

object Metodos {

    // Categorias
    const val ADD_CATEGORIA = "add"
    const val UPDATE_CATEGORIA = "update"
    const val DELETE_CATEGORIA = "delete"
    const val GET_ID_CATEGORIA = "getId"
    const val GET_ALL_CATEGORIA = "getAll"

}