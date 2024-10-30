package com.rafi.input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier){
    var textNama by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textNotelpon by remember { mutableStateOf("") }

    val listJK = listOf("Laki-Laki", "Perempuan")

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelpon by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Biodata",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(15.dp))

        TextField(
            modifier = Modifier.fillMaxWidth()
                .padding(5.dp),
            value = textNama,
            onValueChange = {textNama = it},
            label = {
                Text("Nama")
            },
            placeholder = {
                Text("Masukkan Nama Anda")
            }
        )

        Row {
            listJK.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = textJK == item,
                        onClick = {
                            textJK = item
                        }
                    )
                    Text(item)
                }
            }
        }

        TextField(
            modifier = Modifier.fillMaxWidth()
                .padding(5.dp),
            value = textEmail,
            onValueChange = {textEmail = it},
            label = {
                Text("Email")
            },
            placeholder = {
                Text("Masukkan Email Anda")
            }
        )

        TextField(
            modifier = Modifier.fillMaxWidth()
                .padding(5.dp),
            value = textAlamat,
            onValueChange = {textAlamat = it},
            label = {
                Text("Alamat")
            },
            placeholder = {
                Text("Masukkan Alamat Anda")
            }
        )

        TextField(
            modifier = Modifier.fillMaxWidth()
                .padding(5.dp),
            value = textNotelpon,
            onValueChange = {textNotelpon = it},
            label = {
                Text("No Telpon")
            },
            placeholder = {
                Text("Masukkan No Telpon Anda")
            }
        )

        Button(
            onClick = {
                nama = textNama
                jenis = textJK
                email = textEmail
                alamat = textAlamat
                notelpon = textNotelpon
            }
        ) {
            Text("Submit")
        }
        
        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.Yellow)
        ) {
            Detail(
                judul = "Nama",
                isinya = nama
            )
            Detail(
                judul = "Jenis Kelamin",
                isinya = jenis
            )
            Detail(
                judul = "Email",
                isinya = email
            )
            Detail(
                judul = "Alamat",
                isinya = alamat
            )
            Detail(
                judul = "No Telpon",
                isinya = notelpon
            )
        }

    }
}

@Composable
fun Detail(
    judul: String,
    isinya: String
){
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 2.dp)
        ) {
            Text(
                text = judul,
                modifier = Modifier.weight(1f)
            )
            Text(text = ":",
                modifier = Modifier.weight(0.2f)
            )
            Text(text = isinya,
                modifier = Modifier.weight(2f)
            )
        }


    }
}