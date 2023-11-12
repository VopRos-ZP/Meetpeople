package com.meetpeople.ui.tmp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meetpeople.R

@Preview(showBackground = true)
@Composable
fun DialogCardMeeting() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.test_ava),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(percent = 50))
            )
            Image(
                painter = painterResource(id = R.drawable.test_ava_2),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = (50 / 4).dp)
                    .size(50.dp)
                    .clip(RoundedCornerShape(percent = 50))
            )
            Image(
                painter = painterResource(id = R.drawable.test_ava_3),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = (50 / 2).dp)
                    .size(50.dp)
                    .clip(RoundedCornerShape(percent = 50))
            )
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Хочу поиграть в футбол",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(7.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                    Text(
                        text = "22 октября",
                        fontSize = 12.sp
                    )
                }
            }
            Row {
                Text(text = "13 участников", fontSize = 10.sp)
            }
            Row(
                modifier = Modifier.padding(top = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(text = "Павел:", fontSize = 12.sp)
                Text(text = "Пацаны, с меня мяч короче, ищите поле", fontSize = 12.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DialogCardPerson() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.test_ava),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(percent = 50))
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Алиса Иванова",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(7.dp)
                ) {
                    Icon(
                        painterResource(id = R.drawable.icon_read),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                    Text(
                        text = "12:32",
                        fontSize = 12.sp
                    )
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                Text(text = "Вы:", fontSize = 12.sp)
                Text(text = "Ну так что, куда идем в итоге?", fontSize = 12.sp)
            }
        }
    }
}