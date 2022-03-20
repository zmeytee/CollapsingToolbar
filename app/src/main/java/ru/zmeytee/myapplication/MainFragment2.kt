package ru.zmeytee.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MainFragment2: Fragment(R.layout.fragment_main) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "Fragment2_onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Fragment2_onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "Fragment2_onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "Fragment2_onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Fragment2_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Fragment2_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Fragment2_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Fragment2_onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "Fragment2_onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Fragment2_onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "Fragment2_onDetach")
    }

    companion object {
        const val TAG = "myLogs"
    }

}