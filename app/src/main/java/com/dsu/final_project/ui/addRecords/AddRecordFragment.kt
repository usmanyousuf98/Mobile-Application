package com.dsu.final_project.ui.addRecords

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.dsu.final_project.databinding.RecordFormBinding
import com.dsu.final_project.model.database.RecordDatabase
import com.dsu.final_project.model.datamodel.Record
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AddRecordFragment: Fragment() {
    private var _binding: RecordFormBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val addRecordViewModel =
            ViewModelProvider(this).get(AddRecordViewModal::class.java)
        _binding = RecordFormBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val writeRecordBtn: Button = binding.btnWriteData
        writeRecordBtn.setOnClickListener {
            val addName = binding.etFirstName
            val addDescription = binding.etDesc
            if(addName.text!!.isNotBlank()) {
                val newRecord = Record(
                    null,
                    1,
                    addName.text.toString(),
                    addDescription.text.toString(),
                );
                lifecycleScope.launch(Dispatchers.IO) {
                    Log.d("In Corutine", "addRecord: ")
                    val db = RecordDatabase.getInstance(requireContext());
                    db.recordDao().insert(newRecord)
                }

                addName.setText("")
                addDescription.setText("")

            }
        }


        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
