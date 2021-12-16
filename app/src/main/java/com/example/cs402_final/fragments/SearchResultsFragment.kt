package com.example.cs402_final.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.example.cs402_final.ItemData
import com.example.cs402_final.R
import com.example.cs402_final.adapters.ItemListAdapter
import com.example.cs402_final.adapters.SearchAdapter
import com.example.cs402_final.data_classes.Item
import com.example.cs402_final.data_classes.ItemData
import com.example.cs402_final.data_classes.ItemViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_FRAG = "fragType"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchResults.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchResults : Fragment() {
    // TODO: Rename and change types of parameters
    private var fragType: String? = null


    lateinit var searchRecyclerView: RecyclerView
    private lateinit var resultList : ArrayList<ItemData>
    lateinit var res : LiveData<List<Item>>

    // add our ItemViewModel
    private val mItemViewModel: ItemViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            fragType = it.getString(ARG_FRAG)
            resultList = it.getParcelableArrayList<ItemData>("results") as ArrayList<ItemData>
        } ?: run {
            resultList = ArrayList<ItemData>()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_search_results, container, false)

        return inflater.inflate(R.layout.fragment_search_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        searchRecyclerView = view.findViewById(R.id.search_recycler_view)
//        searchRecyclerView.layoutManager = LinearLayoutManager(this.context)


        if(fragType.equals("search")) {
            searchRecyclerView = view.findViewById(R.id.search_recycler_view)
            searchRecyclerView.layoutManager = LinearLayoutManager(this.context)
            // TODO DB
//            val adapter = ItemListAdapter()
//            searchRecyclerView.adapter = adapter
//            searchRecyclerView.layoutManager = LinearLayoutManager(this.context)
//
            this.context.let {
                // Jacob Below
                // TODO DB

//                searchRecyclerView.apply {
//
//                }
//
//                mItemViewModel.allItems.observe(this)
//
//                // Create new adapter to put DB items into
//                // TODO Use this for DB
//                val adapter = ItemListAdapter()
//                searchRecyclerView.adapter = adapter

                // TODO Use this for ArrayList of ItemData
                val searchAdapter = SearchAdapter(it!!, resultList)

                searchRecyclerView.adapter = searchAdapter

            }
        } else if(fragType.equals("update")) {
            //TODO: init recyclerview for updating quantities

        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchResults.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchResults().apply {
                arguments = Bundle().apply {
                    putString(ARG_FRAG, fragType)
                }
            }
    }
}