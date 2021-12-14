package com.example.cs402_final

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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchResults.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchResults : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var searchRecyclerView: RecyclerView
    private lateinit var resultList : ArrayList<Item>
    lateinit var res : LiveData<List<Item>>

    // add our ItemModel
    private lateinit var mItemModel: ItemModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        val itemObserver = Observer<LiveData<List<Item>>> {
            newName -> res = newName
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search_results, container, false)
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_search_results, container, false)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchRecyclerView = view.findViewById<RecyclerView>(R.id.search_recycler_view)
        searchRecyclerView.layoutManager = LinearLayoutManager(this.context)

        var item = Item(0, "TEST", "Hammer Test", 15.00, 5.00, 5, "TST", "Test Hammer1", "item_loc", "item_upc", "item_img")

        //TODO: This needs to be removed once we get the db working
        resultList = arrayListOf<Item>(Item())
//            ItemData(2, "abc", "Test Item 2", 9.99,5.00,20),
//            ItemData(3, "abc","Test Item 3", 9.99,5.00,20),
//            ItemData(4, "abc","Test Item 4", 9.99,5.00,20))
//
        this.context.let {
//            val searchAdapter: SearchAdapter = SearchAdapter()
            //resultList = emptyList()
            val searchAdapter: SearchAdapter  = SearchAdapter(it!!, resultList)

            searchRecyclerView.adapter = searchAdapter;

            // Set up item model
//            mItemModel = ViewModelProvider(this).get(ItemModel::class.java)
//            mItemModel.readAllData.observe(this, Observer { item ->
//                searchAdapter.setData(item)
//            })
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
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}