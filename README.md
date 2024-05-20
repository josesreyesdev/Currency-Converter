# <em>🌐 Conversor de Monedas </em>

> Una aplicación básica de consola que te permite convertir 
> entre diferentes monedas ejemplo: MXN a USD, etc. Utilizando las tasas de cambio actuales
> con la ayuda del consumo de la API: [ExchangeRate-API](https://app.exchangerate-api.com/)

### Características

* **Conversión de Monedas**: Convierte entre diferentes monedas utilizando las tasas de cambio actuales.
* **Validación de Entrada**: Valida la entrada del usuario para asegurar la correcta ejecución de la conversión.
* **Interfaz de Consola Amigabl**e: Interacción intuitiva con el usuario a través de la consola.


## Desarrollo

### Tecnologías / Construido Con
- 🚀 Java 17
- 💼 Scanner, Operadores condicionales, Bucles
- 📊 JSON Parsing (parsing del archivo de tasas de cambio)
- 📦 Encapsulación, Clases, Métodos, Estructuras de control

### Dependencias / Prerrequisitos

- Java Development Kit (JDK) versión 17 o superior.

### Instalación

1. Clona este repositorio en tu máquina local utilizando el siguiente comando:
```bash
git clone https://github.com/josesreyesdev/Currency-Converter
```
2. Navega al directorio del proyecto:
```bash
cd Currency-Converter
```

### Uso

1. Ejecuta el programa utilizando el siguiente comando:
```bash
javac Main.java
java Main
```
2. Sigue las instrucciones en pantalla para ingresar el código de tu moneda actual, la moneda deseada y la cantidad a convertir.

* **NOTA:** `Utilizar el Código de Moneda de cada país al hacer la consulta, ya sea para dar moneda actual y para la moneda a consultar, ejemplo:` **MXN** para el Peso mexicano,  **USD** para el Dólar Estadounidense `ó como en la siguiente imagen.`

![currency_code.JPG](..%2F..%2F..%2FAlura%2Fcurrency_code.JPG)

* Ingresa tu moneda actual:

![current_currency_code.JPG](..%2F..%2F..%2FAlura%2Fcurrent_currency_code.JPG)

* Ingresa tu moneda deseada

![desired_currency_code.JPG](..%2F..%2F..%2FAlura%2Fdesired_currency_code.JPG)

* Ingresa la cantidad de dinero a convertir

![quantity_to_covert.JPG](..%2F..%2F..%2FAlura%2Fquantity_to_covert.JPG)

* La aplicación mostrará el resultado de la conversión:

![converted_result.JPG](..%2F..%2F..%2FAlura%2Fconverted_result.JPG)

* Posteriormente, puedes inresar **n** si **NO** deseas continuar con la ejecución, 
de lo contrario puedes escribrir cualquier otro caracter para hacer otra consulta y se repite
cada punto del inciso 2.

![finalization.JPG](..%2F..%2F..%2FAlura%2Ffinalization.JPG)