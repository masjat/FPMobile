package com.example.ebasapps.book


import android.content.Context
import com.example.ebasapps.R

class BookRepository(private val context: Context) {
    fun getBooks(): List<Book> {
        return listOf(
            Book(
                id = 1,
                title = context.getString(R.string.book_title_1),
                author = context.getString(R.string.book_author_1),
                rating = 4.5f,
                imageResId = R.drawable.buku1,
                description = "Hampir semua guru akan merasa senang dan bangga ketika dirinya "+
                        "dijuluki sebagai “guru hebat”. Dalam hal ini, “guru hebat” dapat diartikan "+
                        "sebagai seorang guru yang memiliki keinginan untuk terus belajar dan "+
                        "mengembangkan dirinya dimanapun dan kapanpun. Bahkan, guru yang "+
                        "hebat bisa belajar dari kegiatan belajar mengajar berlangsung. Selain itu, "+
                        "guru hebat bisa juga menciptakan suasana belajar mengajar yang menyenangkan."
            ),
            Book(
                id = 2,
                title = context.getString(R.string.book_title_2),
                author = context.getString(R.string.book_author_2),
                rating = 3.8f,
                imageResId = R.drawable.buku2,
                description = "Kemajuan zaman membuat berbagai sektor mengalami kemajuan juga, " +
                        "seperti ilmu pengetahuan, teknologi, dan tingkat kecerdasan para siswa " +
                        "yang semakin tinggi. Semakin tinggi tingkat kecerdasan para siswa, maka" +
                        " semakin besar tugas yang ditanggung oleh seorang guru atau pendidik. " +
                        "Supaya bisa menyampaikan informasi dan ilmu pengetahuan menggunakan " +
                        "teknologi yang semakin modern, maka seorang guru perlu belajar untuk " +
                        "mengembangkan dirinya agar bisa dikenal sebagai “guru hebat”."
            ),
            Book(
                id = 3,
                title = context.getString(R.string.book_title_3),
                author = context.getString(R.string.book_author_3),
                rating = 4.0f,
                imageResId = R.drawable.buku3,
                description = "Pendidikan karakter ini perlu diterapkan disetiap lembaga pendidikan" +
                        " karena akan menghasilkan siswa-siswa yang berkualitas. Dengan pendidikan" +
                        " karakter, seorang siswa akan bisa memilih mana hal yang baik mana hal" +
                        " buruk untuk dirinya, sehingga dikemudian hari nanti seorang siswa dapat " +
                        "menentukan jalan hidupnya dengan penuh keyakinan dan tanpa rasa ragu."
            ),
            Book(
                id = 4,
                title = context.getString(R.string.book_title_4),
                author = context.getString(R.string.book_author_4),
                rating = 4.7f,
                imageResId = R.drawable.buku4,
                description = "Seorang guru harus memiliki sikap profesional karena dengan sikap " +
                        "itu seorang guru bisa bertanggung jawab terhadap tugas-tugasnya. Untuk " +
                        "menjadi seorang guru yang profesional memang membutuhkan proses, sehingga" +
                        " tak bisa langsung jadi seorang guru profesional. Salah satu cara untuk " +
                        "menjadi guru profesional adalah menambah wawasan dengan membaca buku."
            )
        )
    }
    fun findBookById(bookId: Int): Book? {
        return getBooks().find { it.id == bookId }
    }
}

