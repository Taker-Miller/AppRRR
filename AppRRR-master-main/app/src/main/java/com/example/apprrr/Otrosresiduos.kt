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

class OtrosresiduosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.activity_otrosresiduos, container, false)

        // Set padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.principal)) { v, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Botón de descripción de otros residuos
        val buttonDescripcionOtrosResiduos: MaterialButton = view.findViewById(R.id.buttonDescripcionOtrosResiduos)

        buttonDescripcionOtrosResiduos.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Descripción de Otros Residuos")
                .setMessage(getString(R.string.texto_otros_residuos))
                .setPositiveButton("Cerrar") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        return view
    }
}
