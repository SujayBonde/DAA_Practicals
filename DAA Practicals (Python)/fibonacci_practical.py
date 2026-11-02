
terms =  int(input("Enter a Number of terms:"))
if terms <= 0:
    print("Enter a positive number")
else:

	# Non-recursive Program
	first_no =0 
	second_no = 1
	print("Non-Recursive Program")
	print(first_no,end = " ")
	for _ in range(1,terms):
		next_no = first_no+second_no
		first_no,second_no = second_no,next_no
		print(first_no,end = " ")


	# Recursive Program

	def rec(terms,first_no,second_no):
		if terms == 0:
			return 0
	
		print(first_no,end=" ")
		next_no = first_no+second_no
		first_no,second_no = second_no,next_no
		rec(terms-1,first_no,second_no)

	print("\nRecursive Program")
	rec(terms,0,1)