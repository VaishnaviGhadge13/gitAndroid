package com.example.sampleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

public class CreateNextActivity extends AppCompatActivity {
    EditText tittleEditText,contentEditText;
    ImageButton saveNotebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_next);

        tittleEditText=findViewById(R.id.notes_tittle_text);
        contentEditText=findViewById(R.id.notes_content_text);
        saveNotebtn=findViewById(R.id.save_note_btn);

        saveNotebtn.setOnClickListener(v -> saveNote());


    }

    private void saveNote() {
        String noteTittle=tittleEditText.getText().toString();
        String noteContent=contentEditText.getText().toString();

        if(noteTittle==null || noteTittle.isEmpty())
        {
            tittleEditText.setError("Tittle is required");
            return ;
        }
        Note note=new Note();
        note.setTittle(noteTittle);
        note.setContent(noteContent);
        saveNoteToFirebase(note);
    }
    void saveNoteToFirebase(Note note){
        DocumentReference documentReference;
        documentReference=Utility.getCollectionReferenceForNotes().document();

        documentReference.set(note).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    //notes is added
                    Utility.showToast(CreateNextActivity.this,"Note added successfully");
                    finish();
                }
                else {
                    Utility.showToast(CreateNextActivity.this,"Fail While Adding Notes");

                }
            }
        });
    }



}