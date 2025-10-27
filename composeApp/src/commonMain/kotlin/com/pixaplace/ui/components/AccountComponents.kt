import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pixaplace.ui.components.PrimaryButton
import com.pixaplace.ui.components.SecondaryButton

// ------------------------------------------------------------
//  SETTINGS SECTION (list + logout)
// ------------------------------------------------------------
@Composable
fun SettingsSection(onLogout: () -> Unit) {
    Column(modifier = Modifier.padding(24.dp)) {
        Text(
            "Settings",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        SettingsItem(icon = Icons.Default.Person, title = "Full Name", subtitle = "John Doe")
        SettingsItem(icon = Icons.Default.Email, title = "Email", subtitle = "john.doe@example.com")
        SettingsItem(icon = Icons.Default.Lock, title = "Change Password", subtitle = "••••••••")
        SettingsItem(
            icon = Icons.Default.Notifications,
            title = "Notifications",
            subtitle = "Push • Email"
        )

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))

        // Logout
        PrimaryButton(
            text = "Log Out",
            onClick = onLogout,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


// ------------------------------------------------------------
//  SETTINGS ROW
// ------------------------------------------------------------
@Composable
private fun SettingsItem(
    icon: ImageVector,
    title: String,
    subtitle: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .clickable { /* navigate to detail */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(28.dp)
        )
        Spacer(Modifier.width(20.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, style = MaterialTheme.typography.titleMedium)
            Text(
                subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = "Go",
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

// ------------------------------------------------------------
//  PROFILE SECTION (avatar + name + edit)
// ------------------------------------------------------------
@Composable
fun ProfileSection(onEditProfile: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        // Avatar
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile picture",
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(68.dp)
            )
        }

        Spacer(Modifier.height(20.dp))

        // Name & Email
        Text(
            text = "John Doe",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = "john.doe@example.com",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(Modifier.height(24.dp))

        // Edit button
        SecondaryButton(
            text = "Edit Profile",
            onClick = onEditProfile,
            modifier = Modifier.width(200.dp)
        )
    }
}