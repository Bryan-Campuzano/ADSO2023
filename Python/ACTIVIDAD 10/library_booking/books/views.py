from django.shortcuts import render, redirect
from .models import Book
from .forms import BookForm

def book_list(request):
    books = Book.objects.all()
    return render(request, 'books/book_list.html', {'books': books})

def book_detail(request, pk):
    book = Book.objects.get(pk=pk)
    return render(request, 'books/book_detail.html', {'book': book})

def book_create(request):
    if request.method == 'POST':
        form = BookForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect('book_list')  # Redirige a la lista de libros
    else:
        form = BookForm()
    return render(request, 'books/book_form.html', {'form': form})

def book_update(request, pk):
    book = Book.objects.get(pk=pk)
    if request.method == 'POST':
        form = BookForm(request.POST, instance=book)
        if form.is_valid():
            form.save()
            return redirect('book_list')  # Redirige a la lista de libros
    else:
        form = BookForm(instance=book)
    return render(request, 'books/book_form.html', {'form': form})

def book_delete(request, pk):
    book = Book.objects.get(pk=pk)
    if request.method == 'POST':
        book.delete()
        return redirect('book_list')  # Redirige a la lista de libros
    return render(request, 'books/book_confirm_delete.html', {'book': book})
