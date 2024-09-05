package com.paulchibamba.to_docompose.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulchibamba.to_docompose.R

@Composable
fun EmptyContent() {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface), Arrangement.Center, Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(120.dp),
            painter = painterResource(id = R.drawable.ic_dissatisfied_24),
            contentDescription = stringResource(R.string.sad_face_icon),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(text = stringResource(R.string.no_tasks_found),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize)
    }
}

@Preview(showSystemUi = true)
@Composable
fun EmptyContentPreview() {
    EmptyContent()
}