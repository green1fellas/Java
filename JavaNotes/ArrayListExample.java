public class ArrayListExample<T>
{
    private T[] array;

    @SuppressWarnings("unchecked")
    public ArrayListExample()
    {
        array = (T[]) new Object[0];
    }

    public void add(T t)
    {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[array.length + 1];

        // copy everything over to the new array
        for (int i = 0; i < array.length; i++)
        {
            temp[i] = array[i];
        }

        // add the new element
        temp[array.length] = t;
        array = temp;
    }

    public void remove(int index)
    {
        if (index < 0 || index >= array.length) return;
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[array.length - 1];

        boolean found = false;
        // copy everything over to the new element
        for (int i = 0; i < array.length; i++)
        {
            // don't copy if the indices are the same
            if (i == index)
            {
                found = true;
                continue;
            }
            temp[i - (found ? 1 : 0)] = array[i]; // it's i - 1 after the removed object so then it doesn't leave a gap and it doesn't go over the array's length
        }
        array = temp;
    }

    public T get(int index)
    {
        return array[index];
    }
}