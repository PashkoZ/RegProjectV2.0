package com.example.regproject.screens.logInScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.regproject.R
import com.example.regproject.screens.regScreen.isValidEmail

@Composable
fun SignInScreen(navController: NavController){
    var email by remember{ mutableStateOf(TextFieldValue())}
    var password by remember{ mutableStateOf(TextFieldValue())}
    var isPasswordVisible by remember{ mutableStateOf(false)}
    var isValidEmailVar by remember{ mutableStateOf(true)}

Column(horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)){
    Text(text = "Log In")

    OutlinedTextField(value = email,
        onValueChange = {email = it
            isValidEmailVar = isValidEmail(it.text)
        },
        label = { Text(text = "Email")},
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp))

    OutlinedTextField(value = password,
        onValueChange = {password = it},
        label = { Text(text = "Password")},
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val icon = if (isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility
            IconButton(onClick = {isPasswordVisible = !isPasswordVisible}) {
                Icon(icon , contentDescription = null)
            }
        })
    Button(onClick = {}, modifier = Modifier.fillMaxWidth()){
        Text(text = "Log in")
    }

    Spacer(modifier = Modifier.height(16.dp))


    Button(onClick = {}, modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp),
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(0.8.dp, Color.Gray),
        colors = ButtonDefaults.buttonColors(
            Color.White,
            contentColor = Color.Black)) {
        Image(
            painter = painterResource(id = R.drawable.ic_google),
            contentDescription = null
        )
        Text(text = "Log in with Google", modifier = Modifier.padding(6.dp))
    }

    Text(text = "Don't have an account Google?", modifier = Modifier.clickable {navController.navigate("reg_screen")}.padding(8.dp))

}}

@Preview(showBackground = true)
@Composable
fun PreviewSignInScreen(){
    val navController = rememberNavController()
    SignInScreen(navController)
}
