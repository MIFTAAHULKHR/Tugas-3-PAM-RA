package org.tugas3.project

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import tugasindividu3.composeapp.generated.resources.Res
import tugasindividu3.composeapp.generated.resources.my_photo

@Composable
fun App() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                // Data profil Miftahul Khoiriyah
                ProfileHeader(
                    name = "Miftahul Khoiriyah",
                    bio = "Mahasiswa Teknik Informatika Institut Teknologi Sumatera yang berdedikasi tinggi, berorientasi target, dan berkomitmen pada visi misi serta pengabdian masyarakat.",
                    imageRes = painterResource(Res.drawable.my_photo)
                )

                ProfileCard {
                    InfoItem(
                        icon = Icons.Default.Email,
                        label = "Email Address",
                        value = "miftahul.123140064@student.itera.ac.id"
                    )
                    HorizontalDivider(thickness = 0.5.dp, color = Color.LightGray)
                    InfoItem(
                        icon = Icons.Default.Phone,
                        label = "Phone Number",
                        value = "+62 882-7634-6167"
                    )
                    HorizontalDivider(thickness = 0.5.dp, color = Color.LightGray)
                    InfoItem(
                        icon = Icons.Default.LocationOn,
                        label = "Current Location",
                        value = "Lampung, Indonesia"
                    )
                }

                Button(
                    onClick = { /* Implementasi logika buka URL */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("Lihat Profil Lengkap")
                }
            }
        }
    }
}
