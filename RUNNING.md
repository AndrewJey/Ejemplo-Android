

<!-- local-development:start -->
# Desarrollo local

Puedes abrir este repositorio en VS Code, Antigravity o Sublime Text. El compilador y los servicios necesarios dependen del componente indicado abajo.

## Android / Gradle

Importa en Android Studio la carpeta que contiene `settings.gradle`. Hay que revisar juntos el wrapper, Android Gradle Plugin, JDK y SDK antes de sincronizar. Guarda la ruta del SDK en `local.properties`, ignorado por Git, y configura localmente las claves Maps/Firebase. Esta revisión no acredita todavía un APK válido.

## Componentes y validación

Inventario y compilaciones locales del 2026-11-15. Una compilación correcta no acredita todavía interacción, compatibilidad de base de datos, instalador ni despliegue.

| Componente | Tipo / destino | Validación |
| --- | --- | --- |
| [Android-master/AndroidStudio/Ejemplos/Actividades/app/build.gradle](<Android-master/AndroidStudio/Ejemplos/Actividades/app/build.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/Actividades/build.gradle](<Android-master/AndroidStudio/Ejemplos/Actividades/build.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/Actividades/settings.gradle](<Android-master/AndroidStudio/Ejemplos/Actividades/settings.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/BotonesEventos/app/build.gradle](<Android-master/AndroidStudio/Ejemplos/BotonesEventos/app/build.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/BotonesEventos/build.gradle](<Android-master/AndroidStudio/Ejemplos/BotonesEventos/build.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/BotonesEventos/settings.gradle](<Android-master/AndroidStudio/Ejemplos/BotonesEventos/settings.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/Imagenes/app/build.gradle](<Android-master/AndroidStudio/Ejemplos/Imagenes/app/build.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/Imagenes/build.gradle](<Android-master/AndroidStudio/Ejemplos/Imagenes/build.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/Imagenes/settings.gradle](<Android-master/AndroidStudio/Ejemplos/Imagenes/settings.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/MyApplication/app/build.gradle](<Android-master/AndroidStudio/Ejemplos/MyApplication/app/build.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/MyApplication/build.gradle](<Android-master/AndroidStudio/Ejemplos/MyApplication/build.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/MyApplication/settings.gradle](<Android-master/AndroidStudio/Ejemplos/MyApplication/settings.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/Notificaciones/app/build.gradle](<Android-master/AndroidStudio/Ejemplos/Notificaciones/app/build.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/Notificaciones/build.gradle](<Android-master/AndroidStudio/Ejemplos/Notificaciones/build.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/Notificaciones/settings.gradle](<Android-master/AndroidStudio/Ejemplos/Notificaciones/settings.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/ToggleButton/app/build.gradle](<Android-master/AndroidStudio/Ejemplos/ToggleButton/app/build.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/ToggleButton/build.gradle](<Android-master/AndroidStudio/Ejemplos/ToggleButton/build.gradle>) | gradle | Sin ejecutar |
| [Android-master/AndroidStudio/Ejemplos/ToggleButton/settings.gradle](<Android-master/AndroidStudio/Ejemplos/ToggleButton/settings.gradle>) | gradle | Sin ejecutar |

## Archivos ignorados

`.gitignore` excluye credenciales locales, estado del editor y salidas de las herramientas detectadas. No deja de versionar archivos que ya estaban en Git. Los manifiestos, archivos de bloqueo, recursos fuente y scripts de esquema forman parte del código.
<!-- local-development:end -->
