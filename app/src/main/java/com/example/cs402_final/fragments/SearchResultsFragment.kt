package com.example.cs402_final.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.example.cs402_final.ItemData
import com.example.cs402_final.R
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


    private lateinit var searchRecyclerView: RecyclerView
    private lateinit var resultList : ArrayList<ItemData>
    lateinit var res : LiveData<List<Item>>

    // add our ItemViewModel
    private lateinit var mItemViewModel: ItemViewModel

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
        // Mason below
        //TODO: This needs to be removed once we get the db working


        if(fragType.equals("search")) {
            searchRecyclerView = view.findViewById(R.id.search_recycler_view)
            searchRecyclerView.layoutManager = LinearLayoutManager(this.context)

            // TODO For DB
            // val adapter = ItemListAdapter()

//
            this.context.let {
                // Jacob Below
                // TODO DB
                // Get our list of items from DB
                //res = mItemModel.allItems


                // Create new adapter to put items into
                // Sending in res, which is live data is going to cause an error with getItemCount function
//                val itemListAdapter = ItemListAdapter(it!!, res)
//                searchRecyclerView.adapter = itemListAdapter
//                mItemModel = ViewModelProvider(this).get(ItemViewModel::class.java)
//
//                res.observe(viewLifecycleOwner, Observer { itemOb ->
//                    itemListAdapter.setData(itemOb)
//                })


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