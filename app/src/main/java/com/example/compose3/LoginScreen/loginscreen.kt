package com.example.compose3.LoginScreen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen() {
    Surface(
        color = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onSurface
    )

    {
        val regexPattern = "^[a-zA-z0-9_-]{3,16}$"
        val context = LocalContext.current


        var username: String by remember {
            mutableStateOf("")
        }
        var password: String by remember {
            mutableStateOf("")
        }
        var checked by remember {
            mutableStateOf(false)
        }
        Column() {


            Text(
                text = "Login", fontStyle = FontStyle.Normal, fontSize = 30.sp,
                modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.CenterHorizontally),
                color = Color.Blue
            )
            Spacer(modifier = Modifier.size(16.dp))
            TextField(value = username, onValueChange = { newValue ->
                username = newValue
            },
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            TextField(value = password, onValueChange = { newValue ->
                password = newValue
            }, modifier = Modifier.padding(horizontal = 20.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.size(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Row {
                    Checkbox(checked = checked, onCheckedChange = {
                        checked = it

                    })
                    Spacer(modifier = Modifier.size(20.dp))
                    Text(text = "I agree", color = Color.Blue)
                }
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Forget Password?", color = Color.Blue)
                }

            }
            Spacer(modifier = Modifier.size(20.dp))
            Button(
                onClick = {
                    if (username.isEmpty() || password.isEmpty() || password.length > 4) {


                        Toast.makeText(
                            context, "enter valid username and password",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (username.contains(regexPattern))
                        Toast.makeText(
                            context, "invalid username",
                            Toast.LENGTH_LONG
                        ).show()


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = MaterialTheme.shapes.small
            ) {
                Text(text = "LOGIN", color = Color.White)


            }

        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}