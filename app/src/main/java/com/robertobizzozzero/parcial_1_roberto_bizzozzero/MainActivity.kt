package com.robertobizzozzero.parcial_1_roberto_bizzozzero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.robertobizzozzero.parcial_1_roberto_bizzozzero.ui.theme.Parcial_1_roberto_bizzozzeroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormularioProducto()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Parcial_1_roberto_bizzozzeroTheme {
        FormularioProducto()
    }
}

@Composable
fun FormularioProducto() {
    var nombreProducto by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var marca by remember { mutableStateOf("") }
    var existencia by remember { mutableStateOf("") }
    var categoriaSeleccionada by remember { mutableStateOf("") }
    val listaCategoria = listOf("Electrónica", "Ropa", "Alimentos")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = nombreProducto,
            onValueChange = { nombreProducto = it },
            label = { Text("Nombre del Producto") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = marca,
            onValueChange = { marca = it },
            label = { Text("Marca") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = existencia,
            onValueChange = { existencia = it },
            label = { Text("Existencia") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text("Categoría:")
        listaCategoria.forEach { categoria ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = categoria == categoriaSeleccionada,
                    onClick = { categoriaSeleccionada = categoria }
                )
                Text(text = categoria)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                nombreProducto = ""
                precio = ""
                marca = ""
                existencia = ""
                categoriaSeleccionada = ""
            },
            modifier = Modifier
                .width(100.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Enviar")
        }
    }
}