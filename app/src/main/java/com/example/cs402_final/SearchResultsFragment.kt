package com.example.cs402_final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

    // add our ItemModel
    private lateinit var mItemModel: ItemModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            fragType = it.getString(ARG_FRAG)
            resultList = it.getParcelableArrayList<ItemData>("results") as ArrayList<ItemData>
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val view = inflater.inflate(R.layout.fragment_search_results, container, false)


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(fragType.equals("search")) {
            searchRecyclerView = view.findViewById<RecyclerView>(R.id.search_recycler_view)
            searchRecyclerView.layoutManager = LinearLayoutManager(this.context)
//
            this.context.let {
//            val searchAdapter: SearchAdapter = SearchAdapter()
                //resultList = emptyList()
                val searchAdapter: SearchAdapter = SearchAdapter(it!!, resultList)
                searchRecyclerView.adapter = searchAdapter;

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