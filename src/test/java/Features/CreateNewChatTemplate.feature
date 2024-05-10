Feature: Chat Template - Create New Chat Template
   #Scenario 1
  @scenario1
  Scenario: User menekan button Create New Template
    Given User sudah login
    And User berada di halaman Chat Template
    And User belum pernah membuat Chat Template sebelumnya dan terdapat button “Create New Template”
    When User menekan button “Create New Template”
    Then Menampilkan pop-up Create New Chat Template
    And terbagi menjadi 2 bagian, yaitu bagian “Editorial Template” dan bagian “Preview Template”
    And pada bagian “Editorial Template” terdapat input form “Template Name” dan button “Load Existing” Box bubble chat 1 button “Add Bubble Chat” dan button “Wait For Second” Input form “Template Hotkey” (Defaultnya tergenerate oleh sistem)
    And pada bagian “Preview Template” akan menampilkan contoh pesan seperti pada Bubble chat yang telah ditambahkan
    And pada kanan bawah pop-up terdapat button “Save Template”

    #Scenario 2
  @scenario2
  Scenario: User memberi nama template
    When User klik dan mengetikkan “Promo produk” pada form Template Name
    Then Input form Template Name akan aktif dan terisi “Promo produk”

    #Scenario 3
  @scenario3
  Scenario: User membuat pesan pada bubble chat 1
    When User klik dan mengetikkan “Promo produk terbaru tahun ini” pada form box Bubble Chat 1
    Then Box bubble chat 1 akan terisi pesan “Promo produk terbaru tahun ini”
    And pada bagian Preview menampilkan bubble chat dengan pesan “Promo produk terbaru tahun ini”

  #Scenario 4
  @scenario4
  Scenario: User menambahkan bubble chat baru
    When User klik button “Add Bubble Chat”
    Then Akan muncul bubble chat baru pada bagian “Editorial Template”

    #Scenario 5
  @scenario5
  Scenario: User membuat pesan pada bubble chat 2
    When User klik button “Add File”
    And klik pilihan “Image”
    And user memilih image dari komputernya
    Then Image yang dipilih akan ditambahkan pada box bubble chat 2
    And pada bagian Preview menampilkan bubble chat 2 dengan pesan “Image yang ditambahkan”

    #Scenario 6
  @scenario6
  Scenario: User menambahkan text pada bubble chat 2
    When User klik dan mengetikkan “Produk 1, potongan harga 20ribu” pada form box Bubble Chat 2
    Then Box bubble chat 2 akan terisi pesan “Produk 1, potongan harga 20ribu”
    And pada bagian Preview menampilkan bubble chat 2 dengan pesan “[Image] + Produk 1, potongan harga 20ribu”

    #Scenario 7
  @scenario7
  Scenario: User mengganti Template Hotkey
    When User klik dan mengetikkan “Promo2024” pada form Template Hotkey
    Then Input form Template Hotkey akan aktif dan terisi “Promo2024”

    #Scenario 8
  @scenario8
  Scenario: User klik button Create Template
    When User klik button “Create Template”
    Then Pop-up akan tertutup
    And template akan bertambah pada tabel daftar template dengan isi kolom <Template Name>, <Hotkey>, <Created Time>, dan <Guide Book>
    And pada bagian kanan tabel akan terdapat kolom button “Edit” dan “Delete”