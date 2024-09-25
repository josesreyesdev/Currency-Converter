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

* **NOTA:** `Utilizar el Código de Moneda de cada país al hacer la consulta, ya sea para dar moneda actual y para la moneda a consultar, ejemplo:` **MXN** para el Peso mexicano,  **USD** para el Dólar Estadounidense `ó como en la siguiente imagen.` Aqui puedes ver todas las [monedas admitidas](https://www.exchangerate-api.com/docs/supported-currencies)

* Ingresa tu moneda actual:

![current_currency_code](https://github.com/josesreyesdev/Currency-Converter/assets/37203999/90125528-af6d-4990-9f9b-680638433482)

* Ingresa tu moneda deseada
  
![desired_currency_code](https://github.com/josesreyesdev/Currency-Converter/assets/37203999/e1b36783-d3d7-481a-9cb0-ad972aca262f)

* Ingresa la cantidad de dinero a convertir

![quantity_to_convert](https://github.com/josesreyesdev/Currency-Converter/assets/37203999/41ee69e4-8bda-4423-b7d8-cd078bb0fc18)

* La aplicación mostrará el resultado de la conversión:

![converted_result](https://github.com/josesreyesdev/Currency-Converter/assets/37203999/fd2c0095-4805-44ad-93d1-973bb483253e)

* Posteriormente, puedes ingresar **n** si **NO** deseas continuar con la ejecución, 
de lo contrario puedes escribrir cualquier otro caracter para hacer otra consulta y se repite
cada punto desde el paso 2.

![finally](https://github.com/josesreyesdev/Currency-Converter/assets/37203999/3cda9643-14b3-4717-ad5d-5acf9097e1d4)
