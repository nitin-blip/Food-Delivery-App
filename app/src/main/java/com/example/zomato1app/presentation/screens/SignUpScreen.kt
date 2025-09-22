package com.example.zomato1app.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.zomato1app.R
import com.example.zomato1app.data.module.UserData
import com.example.zomato1app.presentation.componets.CheckBoxComponent
import com.example.zomato1app.presentation.componets.OrComponent
import com.example.zomato1app.presentation.navigation.Routes
import com.example.zomato1app.presentation.navigation.SubNavigation
import com.example.zomato1app.presentation.viewModel.ZomViewModel




@Composable
fun SignUpScreen(
    viewModel: ZomViewModel = hiltViewModel(),
    navController: NavController
    ) {
    val state =  viewModel.singUpScreenState.collectAsStateWithLifecycle()


    if (state.value.isLoading){
        Box (modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }else if (state.value.errorMessage != null){
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = state.value.errorMessage!!)
        }
    }else if (state.value.userData != null){
        navController.navigate(SubNavigation.MainHomeScreen)
    }else{

        var fullName by  remember { mutableStateOf("") }
        var  email by remember { mutableStateOf("")  }
        var  address by remember { mutableStateOf("") }
        var  password by  remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }


        Scaffold (modifier = Modifier.fillMaxSize()){ innerPadding ->

            LazyColumn (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = innerPadding.calculateBottomPadding())
            ){
                item {
                    Box(modifier = Modifier.fillMaxWidth()){
                        Image(
                            painter = painterResource(R.drawable.komatosignup),
                            contentDescription ="Zomato  Image",
                            contentScale =  ContentScale.Crop,
                        )
                        Button(onClick = {},
                            modifier = Modifier
                                .padding(vertical = 50.dp, horizontal = 16.dp)
                                .align(Alignment.TopEnd)
                                .clip(CircleShape)
                                .size(width = 78.dp, height = 35.dp),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.LightGray,

                            ),
                            shape = CircleShape
                        ) {
                            Text(text = "Skip",Modifier.clickable{
                                navController.navigate(SubNavigation.MainHomeScreen)
                            })
                        }
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Column (modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally){

                        Text(
                            text = "Get  Started ",
                            fontSize = 44.sp, fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "by creating  a free  account",
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(18.dp))
                    MyTextField(
                        value = fullName,
                        onValueChange = { fullName = it },
                        placeholderValue = "Full Name",
                        painter = painterResource(id = R.drawable.userprofile)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    MyTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholderValue = "Email",
                        painter = painterResource(id = R.drawable.mail)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    MyTextField(
                        value = address,
                        onValueChange = { address = it },
                        placeholderValue = "Address",
                        painter = painterResource(id = R.drawable.address)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    MyTextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholderValue = "Password",
                        painter = painterResource(id = R.drawable.padlock)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    MyTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        placeholderValue = "Confirm Password",
                        painter = painterResource(id = R.drawable.padlock)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    CheckBoxComponent(value = stringResource(id = R.string.term_condition))
                    Spacer(modifier = Modifier.height(20.dp))
                    val  context = LocalContext.current

                   Button(onClick = {
                       if (
                           fullName.isNotBlank() && email.isNotBlank() && address.isNotBlank()
                           && password.isNotBlank() && confirmPassword.isNotBlank()
                       ){
                           if (password == confirmPassword){
                               val  userData = UserData(
                                   userName = fullName,
                                   email = email,
                                   address = address,
                                   password = password
                               )
                               viewModel.createUser(
                                   userData
                               )
                           }else{
                               Toast.makeText(
                                   context,"Password and  Confirm  Password do not match",
                                   Toast.LENGTH_SHORT)
                                   .show()
                           }

                       }else{
                           Toast.
                           makeText(context,
                               "Please Fill All  Fields",Toast.LENGTH_SHORT)
                               .show()
                       }

                   },
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(start = 16.dp, end = 16.dp, bottom = 14.dp)
                           .height(50.dp),
                       colors = ButtonDefaults.buttonColors(colorResource(R.color.addButtonRed)),
                       elevation = ButtonDefaults.elevation(4.dp),
                       shape = RoundedCornerShape(12.dp)


                   ) {
                       Row (modifier = Modifier
                           .fillMaxWidth()
                           .padding(4.dp), Arrangement.Center){

                           Text(text = "Next", fontSize = 22.sp)
                           Spacer(modifier = Modifier.width(4.dp))
                           Icon(
                               painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                               contentDescription = null,
                               modifier = Modifier
                                   .padding(top = 4.dp)
                                   .size(20.dp)
                           )

                       }

                   }
                    Row (modifier = Modifier.fillMaxWidth(), Arrangement.Center){

                        Text("Already  a member ")
                        Spacer(modifier = Modifier.width(2.dp))
                        Text("Login in ",
                            modifier = Modifier.clickable{
                                navController.navigate(Routes.LoginScreen)
                            },
                            color = colorResource(R.color.addButtonRed)
                        )


                    }
                    OrComponent()



                }



            }
        }
    }

}

@Composable
fun MyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderValue: String,
    painter: Painter
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {Text(text = placeholderValue, color = Color.Gray)},
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        singleLine = true,
        textStyle = androidx.compose.ui.text.TextStyle(color =  Color.Black),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.LightGray,
            focusedBorderColor = Color.LightGray

        ),
        keyboardOptions = KeyboardOptions.Default,
        leadingIcon = {
            Icon(
                painter = painter,
                contentDescription = "Icon",
                modifier = Modifier.size(20.dp),
                tint = Color.Gray
            )
        }


    )

}

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderValue: String,  painter: Painter

) {
    val  passwordVisible = remember { mutableStateOf( false) }


    OutlinedTextField(
        value =  value,
        onValueChange = onValueChange,
        placeholder = {Text(text = placeholderValue, color = Color.Gray)},
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp,  end = 16.dp),
        singleLine = true,
        textStyle = TextStyle(color = Color.Black),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.LightGray,
            focusedBorderColor = Color.LightGray
        ),

        leadingIcon = {
            Icon(
                painter = painter,
                contentDescription = "icon",
                modifier = Modifier.size(20.dp),
                tint = Color.Gray

            )
        },
        trailingIcon = {
            val  iconImage = if(passwordVisible.value){
                Icons.Filled.Visibility
            }else{
                Icons.Filled.Visibility

            }
            val  description = if (passwordVisible.value){
                stringResource(R.string.hide_password)
            }else{
                stringResource(R.string.show_password)

            }

            IconButton(onClick = {passwordVisible.value = !passwordVisible.value}) {
                Icon(
                    imageVector = iconImage,
                    contentDescription = description,
                    tint = Color.Gray
                )
            }
        },
        visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()


    )




}
