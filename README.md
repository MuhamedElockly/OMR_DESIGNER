# OMR-Designer - Modern Java Desktop puplle sheet design Application

![PaintPrush Logo](https://img.shields.io/badge/PaintPrush-Modern%20Painting%20App-blue?style=for-the-badge&logo=java)

A modern, feature-rich Java desktop painting application with an enhanced user interface and comprehensive drawing tools.

## 🎨 Features

### Drawing Tools
- **Basic Shapes**: Rectangle, Square, Circle, Oval, Triangle, Line
- **Polygons**: Hexagon, Heptagon, Bentagon
- **Special Shapes**: Round Rectangle, Smiley Faces (3 variants)
- **Free Drawing**: Pencil tool for freehand drawing
- **Text Tool**: Add text to your drawings
- **Selection Tool**: Select and modify existing shapes

### Color Management
- **Fill Color**: Choose colors for shape interiors
- **Stroke Color**: Select colors for shape borders
- **Color Picker**: Advanced color selection tool
- **No Color Option**: Transparent fill option

### Advanced Features
- **Shape Properties**: Modify shape attributes (position, size, color, stroke width)
- **Undo/Redo**: Full undo and redo functionality
- **Copy/Paste**: Duplicate shapes easily
- **Group/Ungroup**: Organize multiple shapes
- **Save/Load**: Export and import drawings
- **Image Loading**: Import background images
- **Zoom Support**: Zoom in/out functionality

### Modern UI Design
- **Responsive Layout**: Adapts to different window sizes
- **Modern Color Scheme**: Professional blue, green, and purple palette
- **Smooth Animations**: Hover effects and transitions
- **Clean Typography**: Segoe UI font for better readability
- **Rounded Corners**: Modern rounded design elements
- **Shadow Effects**: Subtle shadows for depth

## 🚀 Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- NetBeans IDE (recommended) or any Java IDE
- Git (for cloning the repository)

### Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/paintprush.git
   cd paintprush
   ```

2. **Open in NetBeans**
   - Launch NetBeans IDE
   - Go to `File` → `Open Project`
   - Navigate to the `paintprush` folder and select it
   - NetBeans will automatically detect it as a Java project

3. **Build and Run**
   - Right-click on the project in NetBeans
   - Select `Clean and Build`
   - Click the green play button or press `F6` to run

### Alternative: Command Line Build
```bash
# Navigate to project directory
cd paintprush

# Compile the project
javac -cp "src" src/paintprush/*.java src/paintprush/Shapes/*.java

# Run the application
java -cp "src" paintprush.PaintPrushFram
```

## 🎯 Usage Guide

### Getting Started
1. **Launch the Application**: Run `PaintPrushFram.java`
2. **Select a Tool**: Choose from the tools panel on the left
3. **Choose Colors**: Use the color panels in the toolbar
4. **Start Drawing**: Click and drag on the canvas to create shapes

### Tool Selection
- **Selection Tool**: Click to select shapes for modification
- **Shape Tools**: Click and drag to create shapes
- **Pencil Tool**: Freehand drawing with mouse
- **Text Tool**: Click to place text, then type

### Color Management
- **Fill Color Panel**: Click to change shape fill color
- **Stroke Color Panel**: Click to change border color
- **Color Picker**: Advanced color selection with RGB values
- **No Color**: Transparent fill option

### Keyboard Shortcuts
- `Ctrl + S`: Save drawing
- `Ctrl + O`: Open drawing
- `Ctrl + Z`: Undo
- `Ctrl + Y`: Redo
- `Delete`: Delete selected shapes
- `Ctrl + C`: Copy selected shapes
- `Ctrl + V`: Paste shapes

## 🎨 Design Enhancements

### Modern Color Palette
- **Primary Blue**: `#3498db` - Main interface elements
- **Secondary Green**: `#2ecc71` - Success and action buttons
- **Accent Purple**: `#9b59b6` - Highlights and special elements
- **Background Gray**: `#ecf0f1` - Main background
- **Text Dark**: `#34495e` - Primary text color
- **Border Light**: `#bdc3c7` - Subtle borders

### UI Improvements
- **Responsive Design**: Adapts to different screen sizes
- **Modern Typography**: Segoe UI font family
- **Rounded Corners**: Modern rounded button and panel design
- **Shadow Effects**: Subtle shadows for depth perception
- **Hover Effects**: Interactive feedback on mouse hover
- **Clean Layout**: Improved spacing and organization

### Visual Enhancements
- **Anti-aliasing**: Smooth rendering for all graphics
- **Consistent Spacing**: Proper padding and margins
- **Professional Look**: Modern, clean aesthetic
- **Accessibility**: High contrast colors for better visibility

## 🏗️ Project Structure

```
paintprush/
├── src/
│   └── paintprush/
│       ├── PaintPrushFram.java      # Main application frame
│       ├── DrawPanel.java           # Main drawing canvas
│       ├── ToolsPanel.java          # Drawing tools panel
│       ├── PropertiesPanel.java     # Shape properties panel
│       ├── ColorPanel.java          # Color selection panel
│       ├── StrokeColor.java         # Stroke color panel
│       ├── ShapesColor.java         # Fill color panel
│       ├── PropertyJTable.java      # Properties table
│       ├── Shape.java               # Base shape class
│       ├── ShapeFactory.java        # Shape creation factory
│       ├── ShapesEnum.java          # Shape type enumeration
│       ├── CompositeShape.java      # Grouped shapes
│       ├── Context_Menu.java        # Right-click context menu
│       ├── Keypoard_Events.java     # Keyboard event handling
│       ├── Alligment.java           # Shape alignment utilities
│       ├── Utility.java             # General utilities
│       ├── Indexing.java            # Index management
│       ├── InvisibleTextField.java  # Hidden text input
│       ├── Icons/                   # Application icons
│       └── Shapes/                  # Individual shape implementations
│           ├── Circle.java
│           ├── Rectangle.java
│           ├── Triangle.java
│           ├── Line.java
│           ├── Pencil.java
│           ├── Text.java
│           └── ... (other shapes)
├── test/                           # Test files
├── build.xml                       # Ant build file
├── manifest.mf                     # JAR manifest
└── README.md                       # This file
```

## 🛠️ Technical Details

### Architecture
- **MVC Pattern**: Model-View-Controller architecture
- **Factory Pattern**: Shape creation using factory pattern
- **Observer Pattern**: Event handling and updates
- **Composite Pattern**: Grouped shapes implementation

### Technologies Used
- **Java Swing**: Main UI framework
- **Java AWT**: Graphics and drawing
- **JavaFX**: Some advanced UI components
- **NetBeans**: IDE and form designer

### Key Classes
- `PaintPrushFram`: Main application window
- `DrawPanel`: Canvas for drawing operations
- `Shape`: Abstract base class for all shapes
- `ShapeFactory`: Creates different shape types
- `ToolsPanel`: Contains drawing tools
- `PropertiesPanel`: Shows and edits shape properties

## 🐛 Troubleshooting

### Common Issues

**Application won't start**
- Ensure Java 8+ is installed
- Check that all source files are in the correct package structure
- Verify NetBeans project configuration

**Drawing tools not working**
- Make sure a tool is selected from the tools panel
- Check that the drawing canvas is focused
- Verify mouse events are properly handled

**Colors not applying**
- Ensure color panels are properly initialized
- Check that shape properties are being updated
- Verify color selection events are working

**Save/Load issues**
- Check file permissions in the target directory
- Ensure proper file format handling
- Verify file path construction

