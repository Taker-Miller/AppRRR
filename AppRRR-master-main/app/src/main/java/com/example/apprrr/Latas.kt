package com.example.apprrr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LatasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.activity_latas, container, false)

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.principal)) { v, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonDescripcionLatas: MaterialButton = view.findViewById(R.id.buttonDescripcionLatas)

        buttonDescripcionLatas.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Descripción de Latas")
                .setMessage(getString(R.string.texto_latas))
                .setPositiveButton("Cerrar") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        return view
    }
}
