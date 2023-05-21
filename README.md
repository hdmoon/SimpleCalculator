# SimpleCalculator
A simple calculator project for Kotlin practice.\
This app is written without much consideration of app/code quality. Use with care.

# Ways to improve this app
0. Fix UI issues
   - Dynamically choose the button size - in some screens, some buttons are not visible
   - Support landscape mode layout - ditto
   - Buttons are not centered
1. Split UI code from business logic
   - Business logic is mixed with UI logic, which make the code hard-to-read
   - Currently this code has logic which fetchs data from UI, which should not be done
2. Support decimal point / negate buttons
3. Merge number buttons (0-9) into a common class
4. Add more debug code
5. Add tests

