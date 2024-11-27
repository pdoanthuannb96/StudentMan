package vn.edu.hust.studentman

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddStudentActivity : AppCompatActivity() {
    private lateinit var studentNameEditText: EditText
    private lateinit var studentIdEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        studentNameEditText = findViewById(R.id.edit_student_name)
        studentIdEditText = findViewById(R.id.edit_student_id)
        saveButton = findViewById(R.id.button_save)

        saveButton.setOnClickListener {
            val newName = studentNameEditText.text.toString()
            val newId = studentIdEditText.text.toString()
            if (newName.isNotEmpty() && newId.isNotEmpty()) {
                val resultIntent = Intent()
                resultIntent.putExtra("NEW_NAME", newName)
                resultIntent.putExtra("NEW_ID", newId)

                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}
