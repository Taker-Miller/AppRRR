package com.example.apprrr

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.Insets
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import android.widget.ImageView
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class PlasticoFragment : Fragment() {

    private lateinit var imageView: ImageView
    private val galleryRequestCode = 1001

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_plastico, container, false)

        // Set padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.principal)) { v, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageView = view.findViewById(R.id.imageViewSelected)


        val buttonDescripcionPlastico: MaterialButton = view.findViewById(R.id.buttonDescripcionPlastico)
        buttonDescripcionPlastico.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Descripción del Plástico")
                .setMessage(getString(R.string.texto_plastico))
                .setPositiveButton("Cerrar") { dialog, _ -> dialog.dismiss() }
                .show()
        }


        val buttonIngresarImagen: MaterialButton = view.findViewById(R.id.button4)
        buttonIngresarImagen.setOnClickListener {
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED
            ) {
                openGallery()
            } else {
                requestStoragePermission()
            }
        }

        return view
    }


    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, galleryRequestCode)
    }


    private fun requestStoragePermission() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            galleryRequestCode
        )
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == galleryRequestCode && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openGallery()
        } else {

            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Permiso necesario")
                .setMessage("Para acceder a la galería, es necesario otorgar permiso de almacenamiento.")
                .setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == galleryRequestCode && resultCode == Activity.RESULT_OK) {
            val imageUri: Uri? = data?.data
            imageUri?.let {
                imageView.setImageURI(it)
            }
        }
    }
}
