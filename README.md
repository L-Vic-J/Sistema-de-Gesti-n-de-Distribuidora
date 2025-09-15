Sistema de Gestión de Distribuidora

Este proyecto Este proyecto consiste en el desarrollo de un sistema modular de gestión para una empresa distribuidora, diseñado para administrar de forma eficiente usuarios, camiones, clientes, pedidos y productos. El sistema se centra en la seguridad, la organización por roles y la interacción diferenciada según el tipo de usuario.

Autenticación y Roles:

-Se implementa un sistema de login seguro con control de accesos basado en roles:

-Administrador: Acceso completo a todos los módulos (usuarios, camiones, clientes, pedidos y productos).

-Operador de logística: Acceso limitado a la gestión de camiones, clientes, pedidos y productos (sin acceso a usuarios).

-Cliente: Se conecta mediante una aplicación independiente vía sockets, pudiendo autenticarse, registrar pedidos y consultar su historial.

Módulos Principales:

-Gestión de usuarios (solo administrador).

-Gestión de camiones.

-Gestión de clientes.

-Gestión de pedidos, incluyendo registro y seguimiento.

-Gestión de productos, con control de inventario.

Interfaces de Usuario:

-Cada rol cuenta con interfaces personalizadas, desarrolladas para facilitar la interacción según sus permisos y necesidades, garantizando una experiencia clara y organizada.

Objetivo:

Ofrecer una plataforma centralizada, segura y adaptable para la administración de operaciones logísticas y comerciales en una distribuidora, asegurando que cada usuario acceda únicamente a las funcionalidades que le corresponden.
