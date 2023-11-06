package com.meetpeople.ui.tmp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Chip
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meetpeople.R

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun MeetingCardTmp() {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.test_ava),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(percent = 50))
                )
                Text(text = "Сегрей Гуков")
                Text(text = buildAnnotatedString {
                    withStyle(SpanStyle(color = Color.LightGray)) {
                        append("приглашает")
                    }
                })
            }
            Row(
                modifier = Modifier.height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.width(IntrinsicSize.Max)) {
                    Text(text = "ПН", modifier = Modifier.fillMaxWidth().padding(bottom = 5.dp), textAlign = TextAlign.Center, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "12", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 14.sp)
                    Text(text = "АПР", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 14.sp)
                    Text(text = "2023", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 14.sp)
                    Text(text = "19:00", modifier = Modifier.fillMaxWidth().padding(top = 5.dp), textAlign = TextAlign.Center, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                }
                Divider(modifier = Modifier.width(1.dp).fillMaxHeight())
                Column {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        Text(
                            text = "Хочу сходить погулять по красивой вечерней питерской набережной",
                            modifier = Modifier.padding(top = 5.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Санкт-Петербург, генерала Кравченко 8",
                            fontSize = 12.sp
                        )
                    }
                    Row {
                        Chip(onClick = { /*TODO*/ }) {
                            Text(text = "С девушкой")
                        }
                    }
                }
            }
        }
    }
}