package com.example.zomato1app.presentation.componets



import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zomato1app.R

@Composable
fun CheckBoxComponent(value: String) {
    val  context = LocalContext.current
    val  chechState = remember { mutableStateOf(false) }

    Row (
        modifier = Modifier.fillMaxWidth().height(45.dp).padding( start = 16.dp,  end = 16.dp)
    ){
        Checkbox(checked =  chechState.value,
            onCheckedChange = {
                chechState.value != chechState.value
            },
            colors = CheckboxDefaults.colors(uncheckedColor = Color.Gray)
        )
        Text(value, Modifier.padding(top = 11.dp), fontSize = 11.sp)
        Text("Term", Modifier.padding(start = 2.dp ,  top = 11.dp).clickable{
            Toast.makeText(context, "Term and Condition", Toast.LENGTH_SHORT).show()
        }, fontSize = 11.sp, color = colorResource(R.color.purple_500))
        Text("and", Modifier.padding(start = 2.dp, top= 11.dp,  end = 2.dp), fontSize = 11.sp)
        Text("Condition",  Modifier.padding(top = 11.dp).clickable{
            Toast.makeText(context, "Term and Condition", Toast.LENGTH_SHORT).show()


        },
            fontSize = 11.sp,  color = colorResource(R.color.purple_500)
        )


    }

}
