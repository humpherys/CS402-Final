package com.example.cs402_final.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cs402_final.ItemData
import com.example.cs402_final.R
import com.example.cs402_final.adapters.SearchAdapter
import com.example.cs402_final.data_classes.Item
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

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            fragType = it.getString(ARG_FRAG)
//
//            val itemObserver = Observer<LiveData<List<Item>>> {
//                    newName -> res = newName
//            }
//
//            resultList = it.getParcelableArrayList<ItemData>("results") as ArrayList<Item>
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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


                //resultList = emptyList()

                //Mason below
                resultList = arrayListOf<ItemData>(
                    ItemData(2, "abc", "Test Item 2", 9.99,5.00,20),
                    ItemData(3, "abc","Test Item 3", 9.99,5.00,20),
                    ItemData(4, "abc","Test Item 4", 9.99,5.00,20))


                val searchAdapter = SearchAdapter(it!!, resultList)

                searchRecyclerView.adapter = searchAdapter;

                // Set up item model
    //            mItemModel = ViewModelProvider(this).get(ItemViewModel::class.java)
    //            mItemModel.allItems.observe(this, Observer { item ->
    //                searchAdapter.setData(item as LiveData<List<Item>>)
    //            })

                    //resultList = emptyList()
    //                val searchAdapter: SearchAdapter = SearchAdapter(it!!, resultList)
    //                searchRecyclerView.adapter = searchAdapter;

                    // Set up item model
    //            mItemModel = ViewModelProvider(this).get(ItemModel::class.java)
    //            mItemModel.readAllData.observe(this, Observer { item ->
    //                searchAdapter.setData(item)
    //            })
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