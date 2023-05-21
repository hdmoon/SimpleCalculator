# SimpleCalculator
A simple calculator project for Kotlin practice


# Ways to improve this app
0. Fix UI issues
   - Dynamically choose the button size
   - Support landscape mode layout
   - Buttons are not centered
1. Support decimal point / negate buttons
2. Split UI code from business logic
   - Business logic is mixed with UI logic, which make the code hard-to-read
   - Currently this code has logic which fetchs data from UI, which should not be done
3. Merge number buttons (0-9) into a common class
4. Add more debug code
5. Add tests