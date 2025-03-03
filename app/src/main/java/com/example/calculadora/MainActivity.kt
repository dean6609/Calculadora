package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculadoraApp()
                }
            }
        }
    }
}

@Composable
fun CalculadoraApp() {
    // Variables de estado para los números de entrada y el resultado
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("0") }
    var mensajeError by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Pantalla de resultado
        Text(
            text = "Calculadora UMB",
            fontSize = 32.sp,
            modifier = Modifier.padding(vertical = 26.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray.copy(alpha = 0.3f))
                .padding(16.dp)
        ) {
            Text(
                text = resultado,
                fontSize = 32.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Mensaje de error (si existe)
        if (mensajeError.isNotEmpty()) {
            Text(
                text = mensajeError,
                color = Color.Red,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        // Campos de entrada
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = numero1,
            onValueChange = { numero1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = numero2,
            onValueChange = { numero2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Función auxiliar para validar entrada
        fun validarEntrada(): Pair<Double, Double>? {
            return try {
                if (numero1.isBlank() || numero2.isBlank()) {
                    mensajeError = "Por favor, ingresa ambos números"
                    null
                } else {
                    mensajeError = ""
                    Pair(numero1.toDouble(), numero2.toDouble())
                }
            } catch (e: NumberFormatException) {
                mensajeError = "Por favor, ingresa números válidos"
                null
            }
        }

        // Botones de operaciones
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Botón de Suma (Miembro 1)
            // Botón de Resta (Miembro 1)
            // Botón de Multiplicación (Miembro 2)
            // Botón de División (Miembro 2)
        }

        // Botón para limpiar
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                numero1 = ""
                numero2 = ""
                resultado = "0"
                mensajeError = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Limpiar")
        }
    }
}

// Funciones para las operaciones matemáticas

// Función de Suma (implementada por Miembro 1)
// Función de Resta (implementada por Miembro 1)
// Funciones de Multiplicación (implementado por Miembro 2)
// Funciones de División (implementado por Miembro 2)


@Preview(showBackground = true)
@Composable
fun CalculadoraPreview() {
    CalculadoraTheme {
        CalculadoraApp()
    }
}