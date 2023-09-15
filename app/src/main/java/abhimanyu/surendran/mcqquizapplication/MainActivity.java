package abhimanyu.surendran.mcqquizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<QuestionActivity> list_of_questions;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_of_questions=new ArrayList<>();
        list_of_questions.add(new QuestionActivity("What is the capital city of India?","New Delhi","Mumbai","Kolkata","Chennai","New Delhi"));
        list_of_questions.add(new QuestionActivity("Which river is known as the Ganga in India?","Yamuna","Brahmaputra","Indus","Ganges","Ganges"));
        list_of_questions.add(new QuestionActivity("Which monument is often called the Symbol of Love?","Qutub Minar","India Gate","Taj Mahal","Red Fort","Taj Mahal"));
        list_of_questions.add(new QuestionActivity("Which festival is popularly known as the Festival of Lights?","Diwali","Holi","Durga Puja","Eid","Diwali"));
        list_of_questions.add(new QuestionActivity("The Indian national flag has how many colors?","2","3","4","5","3"));
        list_of_questions.add(new QuestionActivity("Which animal is the national symbol of India?","Lion","Elephant","Tiger","Peacock","Tiger"));
        list_of_questions.add(new QuestionActivity("The highest mountain peak in India is called:","Mount Everest","Kanchenjunga"," Nanda Devi","Annapurna","Kanchenjunga"));
        list_of_questions.add(new QuestionActivity("What is the national currency of India?","Rupee","Rupiah","Ringgit","Riyal"," Rupee"));
        list_of_questions.add(new QuestionActivity("Who is known as the Father of the Indian Constitution?","Mahatma Gandhi"," Jawaharlal Nehru","B.R. Ambedkar","Sardar Patel","B.R. Ambedkar"));
        list_of_questions.add(new QuestionActivity("The largest state in India by area is:","Maharashtra","Uttar Pradesh","Madhya Pradesh","Rajasthan","Rajasthan"));
        list_of_questions.add(new QuestionActivity("The famous dance form Bharatanatyam originated in which Indian state?","Kerala","Tamil Nadu"," Odisha","Karnataka","Tamil Nadu"));
        list_of_questions.add(new QuestionActivity("Who was the first Prime Minister of India?","Jawaharlal Nehru","Sardar Patel","Indira Gandhi"," Rajendra Prasad"," Jawaharlal Nehru"));
        list_of_questions.add(new QuestionActivity("What is the national flower of India?"," Rose","Lotus","Jasmine","Marigold","Lotus"));
        list_of_questions.add(new QuestionActivity("The Indian Space Research Organisation (ISRO) is headquartered in:","Bangalore","Mumbai","New Delhi","Chennai","Bangalore"));
        list_of_questions.add(new QuestionActivity("Which Indian festival is also known as the Festival of Harvest?","Diwali","Pongal","Holi","Eid"," Pongal"));
        list_of_questions.add(new QuestionActivity("The famous historical site Ellora Caves is located in which state of India?","Madhya Pradesh","Maharashtra","Karnataka","Rajasthan","Maharashtra"));
        list_of_questions.add(new QuestionActivity("What is the national emblem of India?","Lotus","Peacock","Lion","Ashoka Chakra","Ashoka Chakra"));
        list_of_questions.add(new QuestionActivity("Who composed the Indian national anthem, Jana Gana Mana?","Rabindranath Tagore"," Mahatma Gandhi","Jawaharlal Nehru"," Subhas Chandra Bose","Rabindranath Tagore"));
        list_of_questions.add(new QuestionActivity("The city of Mumbai was formerly known as:","Calcutta","Bombay","Madras","Delhi","Bombay"));
        list_of_questions.add(new QuestionActivity("The Gateway of India monument is located in which city?","Kolkata","New Delhi","Mumbai","Chennai","Mumbai"));
        list_of_questions.add(new QuestionActivity("The Indian state famous for its backwaters and houseboats is:","Kerala","Goa","Tamil Nadu","Karnataka","Kerala"));
        list_of_questions.add(new QuestionActivity("The first war of Indian independence against British rule took place in:","1757","1857","1905","1942","1857"));
        list_of_questions.add(new QuestionActivity("Which Indian cricketer is often referred to as the God of Cricket?","Rahul Dravid","Sachin Tendulkar","Virat Kohli","Sourav Ganguly","Sachin Tendulkar"));
        list_of_questions.add(new QuestionActivity("The famous Indian festival Ganesh Chaturthi is dedicated to which deity?","Lord Shiva"," Goddess Durga","Lord Ganesha","Lord Krishna","Lord Ganesha"));
        list_of_questions.add(new QuestionActivity("The Indian state of Assam is known for producing which popular tea variety?","Darjeeling Tea","Oolong Tea","Earl Grey Tea","Assam Tea","Assam Tea"));
        list_of_questions.add(new QuestionActivity("Who was the leader of the Indian independence movement and known for his philosophy of nonviolent resistance?","Subhas Chandra Bose","Bhagat Singh","Mahatma Gandhi","Jawaharlal Nehru","Mahatma Gandhi"));
        list_of_questions.add(new QuestionActivity("The Red Fort in Delhi served as the main residence of which historical dynasty in India?","Mughal Dynasty","Gupta Dynasty","Maurya Dynasty","Chola Dynasty","Mughal Dynasty"));
        list_of_questions.add(new QuestionActivity("The famous temple complex Khajuraho Group of Monuments is known for its intricate:","Paintings","Sculptures","Architecture","Murals","Sculptures"));
        list_of_questions.add(new QuestionActivity("In which year did India gain independence from British rule?","1942","1947","1950","1965","1947"));
        list_of_questions.add(new QuestionActivity("Which Indian woman astronaut became the first Indian to travel to space?","Kalpana Chawla","Sunita Williams","Indira Gandhi","Ritu Karidhal","Kalpana Chawla"));

        Button start_quiz = findViewById(R.id.start_quiz);
        start_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });


    }
}