package com.example.lesson6_lists.data;

import com.example.lesson6_lists.domain.Note;
import com.example.lesson6_lists.domain.NoteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class MemoryNoteRepositoryImpl implements NoteRepository {

    private final List<Note> notes = new ArrayList<>(sampleNoteList());

    private static List<Note> sampleNoteList() {
        List<Note> list = new ArrayList<>();
        list.add(new Note("Кредит", "8700 руб"));
        list.add(new Note("Рецепт салата с авокадо", "Нарежьте помидоры, огурцы и " +
                "авокадо крупными кусочками, а лук — тонкими полосками. Добавьте рубленую петрушку, масло, " +
                "лимонный сок, соль и перец и перемешайте."));
        list.add(new Note("Ссылки", "1. http://www.specialdefects.com/v2/ - походить по песку\n" +
                "2. https://multator.ru/draw/ - рисовать мультики\n" +
                "3. http://mailfuture.ru/write/ - письмо в будущее\n" +
                "4. http://kakoysegodnyadennedeli.ru/ - какой сегодня день недели\n" +
                "5. http://first-ever.ru/ - сайт про всё самое первое\n" +
                "6. http://proteys.info/404/ - джага\n" +
                "7. http://e.ggtimer.com/ - таймер для ежедневных нужд\n" +
                "8. http://tonematrix.audiotool.com/ - сочинять музыку\n" +
                "9. https://virtualpiano.net/ - играть на синтезаторе\n"));
        list.add(new Note("Ремонт", "трубы, смесители, муфты, " +
                "фитинговые соединения, тройники, уголки, ниппели, шаровые краны, отводы"));
        list.add(new Note("День рождения", "Парк Победы беседка №5 в 17:00"));
        list.add(new Note("Фильмы", "1. Рокки\n" +
                "2. Терминатор\n" +
                "3. Фантомас\n" +
                "4. Дюна\n" +
                "5. Три мушкетера"));
        list.add(new Note("Пакет документов", "Паспорт, ИНН, Полис"));
        list.add(new Note("Зубной", "В 18:00 28.01"));
        list.add(new Note("Оплатить интернет", "680 руб."));
        list.add(new Note("Бильярд", "Баричхолл в пятницу в 19:00"));
        list.add(new Note("Горные лыжи", "Мраткино"));
        return list;
    }

    @Override
    public List<Note> getNotes() {
        return notes;
    }


    @Override
    public Note createNote() {
        Note note = new Note();
        notes.add(note);
        return note;
    }

    @Override
    public boolean updateNote(Note note) {
        return true; // ничего не делаем, т.к. все заметки хранятся в памяти и обновляются во время редактириования
    }

    @Override
    public Note findNote(UUID noteId) {
        int index = indexOf(noteId);
        if (index == -1) {
            return null;
        }
        return notes.get(index);
    }

    @Override
    public boolean removeNote(UUID noteId) {
        int index = indexOf(noteId);
        if (index == -1) {
            return false;
        }
        notes.remove(index);
        return true;
    }

    private int indexOf(UUID noteId) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId().equals(noteId)) {
                return i;
            }
        }
        return -1;
    }

}
