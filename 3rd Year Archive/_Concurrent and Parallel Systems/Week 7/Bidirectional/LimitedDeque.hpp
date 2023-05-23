#ifndef __LIMITED_DEQUE_HPP
#define __LIMITED_DEQUE_HPP

#include <type_traits>
#include <deque>
#include <mutex>
#include <condition_variable>
#include <chrono>

template <class T, std::size_t MaxSize = 10, class Alloc = std::allocator<T>>
class LimitedDeque : public std::deque<T, Alloc>
{
  public:
    typedef T value_type;
    typedef Alloc allocator_type;
    typedef std::size_t size_type;

    LimitedDeque() : std::deque<T, Alloc> () {}
    explicit LimitedDeque(const allocator_type& alloc) : std::deque<T, Alloc> (alloc) {}
    explicit LimitedDeque (size_type n, const allocator_type& alloc = allocator_type()) : std::deque<T, Alloc> (n, alloc)
    {
      if (n > MaxSize)
      {
        std::bad_alloc ba;

        this -> std::deque<T,Alloc>::clear();

        throw ba;
      }
    }

    LimitedDeque (size_type n, const value_type& val, const allocator_type& alloc = allocator_type()) : std::deque<T, Alloc> (n, val, alloc)
    {
      if (n > MaxSize)
      {
        std::bad_alloc ba;

        this -> std::deque<T,Alloc>::clear();

        throw ba;
      }
    }

    template <class InputIterator> LimitedDeque (InputIterator first, InputIterator last, const allocator_type& alloc = allocator_type()) : std::deque<T, Alloc> (first, last, alloc)
    {
      unsigned int n = 0;
      InputIterator first_copy = first, last_copy = last;

      for (n = 0; first_copy != last_copy; ++first_copy, ++n);

      if (this->size() + n > MaxSize)
      {
        std::bad_alloc ba;

        this -> std::deque<T,Alloc>::clear();

        throw ba;
      }
    }

    LimitedDeque (const LimitedDeque& x) : std::deque<T, Alloc> (x) { }
    LimitedDeque (const LimitedDeque& x, const allocator_type& alloc) : std::deque<T, Alloc> (x, alloc) { }

    template <class U, std::size_t MaxSizeSecond, class AllocSecond = std::allocator<U>,
    class = typename std::enable_if<std::is_convertible<U, T>::value>::type>
    LimitedDeque (const LimitedDeque<U, MaxSizeSecond, AllocSecond>& x) : std::deque<T, Alloc> (x)
    {
      if (x.size() > MaxSize)
      {
        std::bad_alloc ba;

        this -> std::deque<T,Alloc>::clear();

        throw ba;
      }
    }

    template <class U, std::size_t MaxSizeSecond, class AllocSecond = std::allocator<U>,
    class = typename std::enable_if<std::is_convertible<U, T>::value>::type>
    LimitedDeque (const LimitedDeque& x, const allocator_type& alloc) : std::deque<T, Alloc> (x, alloc)
    {
      if (x.size() > MaxSize)
      {
        std::bad_alloc ba;

        this -> std::deque<T,Alloc>::clear();

        throw ba;
      }
    }

    LimitedDeque (LimitedDeque&& x) : std::deque<T, Alloc> (x) { }
    LimitedDeque (LimitedDeque&& x, const allocator_type& alloc) : std::deque<T, Alloc> (x, alloc) { }

    template <class U, std::size_t MaxSizeSecond, class AllocSecond = std::allocator<U>,
    class = typename std::enable_if<std::is_convertible<U, T>::value>::type>
    LimitedDeque (LimitedDeque&& x) : std::deque<T, Alloc> (x)
    {
      if (x.size() > MaxSize)
      {
        std::bad_alloc ba;

        this -> std::deque<T,Alloc>::clear();

        throw ba;
      }
    }

    template <class U, std::size_t MaxSizeSecond, class AllocSecond = std::allocator<U>,
    class = typename std::enable_if<std::is_convertible<U, T>::value>::type>
    LimitedDeque (LimitedDeque&& x, const allocator_type& alloc) : std::deque<T, Alloc> (x, alloc)
    {
      if (x.size() > MaxSize)
      {
        std::bad_alloc ba;

        this -> std::deque<T,Alloc>::clear();

        throw ba;
      }
    }

    LimitedDeque (std::initializer_list<value_type> il, const allocator_type& alloc = allocator_type()) : std::deque<T, Alloc> (il, alloc)
    {
      if (il.size() > MaxSize)
      {
        std::bad_alloc ba;

        this -> std::deque<T,Alloc>::clear();

        throw ba;
      }
    }

    size_type max_size() const noexcept
    {
      return MaxSize;
    }

    void resize (size_type n)
    {
      if (n > MaxSize)
      {
        std::bad_alloc ba;
        throw ba;
      }

      this -> std::deque<T, Alloc>::resize(n);
    }

    void resize (size_type n, const value_type& val)
    {
      if (n > MaxSize)
      {
        std::bad_alloc ba;
        throw ba;
      }

      this -> std::deque<T, Alloc>::resize(n, val);
    }

    void push_back (const value_type& val)
    {
      if (this->size() + 1 > MaxSize)
      {
        std::bad_alloc ba;
        throw ba;
      }

      this -> std::deque<T, Alloc>::push_back(val);
    }

    void push_back (value_type&& val)
    {
      if (this->size() + 1 > MaxSize)
      {
        std::bad_alloc ba;
        throw ba;
      }

      this -> std::deque<T, Alloc>::push_back(val);
    }

    void push_front (const value_type& val)
    {
      if (this->size() + 1 > MaxSize)
      {
        std::bad_alloc ba;
        throw ba;
      }

      this -> std::deque<T, Alloc>::push_front(val);
    }

    void push_front (value_type&& val)
    {
      if (this->size() + 1 > MaxSize)
      {
        std::bad_alloc ba;
        throw ba;
      }

      this -> std::deque<T, Alloc>::push_front(val);
    }

    typename std::deque<T, Alloc>::iterator insert (typename std::deque<T, Alloc>::const_iterator position, const value_type& val)
    {
      if (this->size() + 1 > MaxSize)
      {
        std::bad_alloc ba;
        throw ba;
      }

      return this -> std::deque<T, Alloc>::insert(position, val);
    }

    typename std::deque<T, Alloc>::iterator insert (typename std::deque<T, Alloc>::const_iterator position, size_type n, const value_type& val)
    {
      if (this->size() + n > MaxSize)
      {
        std::bad_alloc ba;
        throw ba;
      }

      return this -> std::deque<T, Alloc>::insert(position, n, val);
    }

    template <class InputIterator> typename std::deque<T, Alloc>::iterator insert (typename std::deque<T, Alloc>::const_iterator position, InputIterator first, InputIterator last)
    {
      unsigned int n = 0;
      InputIterator first_copy = first, last_copy = last;

      for (n = 0; first_copy != last_copy; ++first_copy, ++n);

      if (this->size() + n > MaxSize)
      {
        std::bad_alloc ba;
        throw ba;
      }

      return this -> std::deque<T, Alloc>::insert(position, first, last);
    }

    typename std::deque<T, Alloc>::iterator insert (typename std::deque<T, Alloc>::const_iterator position, value_type&& val)
    {
      if (this->size() + 1 > MaxSize)
      {
        std::bad_alloc ba;
        throw ba;
      }

      return this -> std::deque<T, Alloc>::insert(position, val);
    }

    typename std::deque<T, Alloc>::iterator insert (typename std::deque<T, Alloc>::const_iterator position, std::initializer_list<value_type> il)
    {
      if (this->size() + il.size() > MaxSize)
      {
        std::bad_alloc ba;
        throw ba;
      }

      return this -> std::deque<T, Alloc>::insert(position, il);
    }

    template <class... Args> typename std::deque<T, Alloc>::iterator emplace (typename std::deque<T, Alloc>::const_iterator position, Args&&... args)
    {
      if (this->size() + 1 > MaxSize)
      {
        std::bad_alloc ba;
        throw ba;
      }

      return this -> std::deque<T, Alloc>::emplace(position, args ...);
    }

    template <class... Args> void emplace_front (Args&&... args)
    {
      if (this->size() + 1 > MaxSize)
      {
        std::bad_alloc ba;
        throw ba;
      }

      this -> std::deque<T, Alloc>::emplace_front(args ...);
    }

    template <class... Args> void emplace_back (Args&&... args)
    {
      if (this->size() + 1 > MaxSize)
      {
        std::bad_alloc ba;
        throw ba;
      }

      this -> std::deque<T, Alloc>::emplace_back(args ...);
    }
};

#endif //__LIMITED_DEQUE_HPP
