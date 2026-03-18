package org.tugas3.project

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.resources.painterResource
import org.tugas3.project.data.ProfileUiState
import org.tugas3.project.ui.InfoItem
import org.tugas3.project.ui.ProfileCard
import org.tugas3.project.ui.ProfileHeader
import org.tugas3.project.viewmodel.ProfileViewModel
import tugasindividu3.composeapp.generated.resources.Res
import tugasindividu3.composeapp.generated.resources.my_photo

@Composable
fun App(viewModel: ProfileViewModel = viewModel { ProfileViewModel() }) {
    val uiState by viewModel.uiState.collectAsState()
    var isEditing by remember { mutableStateOf(false) }

    val darkTheme = uiState.isDarkMode || isSystemInDarkTheme()

    MaterialTheme(
        colorScheme = if (darkTheme) darkColorScheme() else lightColorScheme()
    ) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            if (isEditing) {
                EditProfileScreen(
                    uiState = uiState,
                    onSave = { name, bio ->
                        viewModel.updateName(name)
                        viewModel.updateBio(bio)
                        isEditing = false
                    },
                    onCancel = { isEditing = false }
                )
            } else {
                ProfileScreen(
                    uiState = uiState,
                    onEditClick = { isEditing = true },
                    onDarkModeToggle = { viewModel.toggleDarkMode(it) }
                )
            }
        }
    }
}

@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    onEditClick: () -> Unit,
    onDarkModeToggle: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Dark Mode", style = MaterialTheme.typography.labelLarge)
            Switch(checked = uiState.isDarkMode, onCheckedChange = onDarkModeToggle)
        }

        ProfileHeader(
            name = uiState.name,
            bio = uiState.bio,
            imageRes = painterResource(Res.drawable.my_photo)
        )

        ProfileCard {
            InfoItem(
                icon = Icons.Default.Email,
                label = "Email Address",
                value = uiState.email
            )
            HorizontalDivider(thickness = 0.5.dp, color = Color.LightGray)
            InfoItem(
                icon = Icons.Default.Phone,
                label = "Phone Number",
                value = uiState.phone
            )
            HorizontalDivider(thickness = 0.5.dp, color = Color.LightGray)
            InfoItem(
                icon = Icons.Default.LocationOn,
                label = "Current Location",
                value = uiState.location
            )
        }

        Button(
            onClick = onEditClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .height(56.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Icon(Icons.Default.Edit, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text("Edit Profile")
        }
    }
}

@Composable
fun EditProfileScreen(
    uiState: ProfileUiState,
    onSave: (String, String) -> Unit,
    onCancel: () -> Unit
) {
    var name by remember { mutableStateOf(uiState.name) }
    var bio by remember { mutableStateOf(uiState.bio) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Edit Profile",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = bio,
            onValueChange = { bio = it },
            label = { Text("Bio") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
            minLines = 3
        )

        Button(
            onClick = { onSave(name, bio) },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("Save Changes")
        }

        TextButton(
            onClick = onCancel,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Cancel")
        }
    }
}
