package com.liwa.touristapp2

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val destinations = listOf(
            Destination(
                "Paris",
                "Paris is famous for the Eiffel Tower, museums, and beautiful streets.\n\nTravel Tip: Visit in the evening to enjoy the city lights.",
                R.drawable.paris
            ),

            Destination(
                "Dubai",
                "Dubai is known for its modern buildings, luxury shopping, and desert adventures.\n\nTravel Tip: Visit Burj Khalifa and try a desert safari.",
                R.drawable.dubai
            ),

            Destination(
                "Tokyo",
                "Tokyo is a city where Japanese tradition and modern technology come together.\n\nTravel Tip: Visit temples, modern shopping areas, and try Japanese food.",
                R.drawable.tokyo
            ),

            Destination(
                "Istanbul",
                "Istanbul is a historic city that connects Europe and Asia. It is known for mosques, markets, and old buildings.\n\nTravel Tip: Visit Hagia Sophia, Blue Mosque, and the Grand Bazaar.",
                R.drawable.istanbul
            ),

            Destination(
                "Kuala Lumpur",
                "Kuala Lumpur is the capital city of Malaysia and is famous for the Petronas Twin Towers.\n\nTravel Tip: Visit the towers at night and enjoy Malaysian food.",
                R.drawable.kil
            ),

            Destination(
                "Makkah",
                "Makkah is one of the most important cities in Saudi Arabia and is home to the Holy Mosque.\n\nTravel Tip: Visit with proper planning, especially during busy seasons.",
                R.drawable.makkah
            ),

            Destination(
                "Madinah",
                "Madinah is a peaceful city known for Al-Masjid an-Nabawi and its beautiful Islamic history.\n\nTravel Tip: Spend time visiting the mosque area and nearby historical places.",
                R.drawable.madinah
            ),

            Destination(
                "Cairo",
                "Cairo is the capital of Egypt and is famous for the Pyramids of Giza and ancient history.\n\nTravel Tip: Visit the pyramids early in the morning to avoid heavy crowds.",
                R.drawable.cairo
            ),

            Destination(
                "London",
                "London is a famous city known for Big Ben, museums, bridges, and historical buildings.\n\nTravel Tip: Use public transport to explore the city easily.",
                R.drawable.london
            ),

            Destination(
                "Cape Town",
                "Cape Town is a beautiful city in South Africa known for Table Mountain and its waterfront.\n\nTravel Tip: Visit Table Mountain on a clear day for the best view.",
                R.drawable.cape_town
            )
        )
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = DestinationAdapter(destinations)
        recyclerView.adapter = adapter

        val searchBox = findViewById<EditText>(R.id.searchBox)

        searchBox.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }
}