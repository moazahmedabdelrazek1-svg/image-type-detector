# 🖼️ Image Type Detector

A Java application that detects image file formats through byte-level binary signature analysis — no file extension needed.

## 📌 About

This project identifies image file types by inspecting the raw binary content at the beginning of each file. Every image format has a unique **byte signature** (magic number) embedded in its header. This program reads those bytes and matches them against known signatures to determine the file type accurately.

## 🎯 Supported Formats

| Format | Description |
|--------|-------------|
| JPEG | Joint Photographic Experts Group |
| PNG | Portable Network Graphics |
| GIF | Graphics Interchange Format |
| BMP | Bitmap Image |
| TIFF | Tagged Image File Format |
| RAW | Raw Image Data |

## 🛠️ Built With

- **Java** — Core language
- **File I/O** — Binary file reading
- **Multimedia Standards** — Format specification research

## 💡 How It Works

1. Opens the file in binary read mode
2. Reads the first bytes of the file (file header)
3. Matches the bytes against known image format signatures
4. Returns the correct image type — independent of the file extension

## 🚀 How to Run

```bash
# Clone the repository
git clone https://github.com/moaz-ahmed/image-type-detector.git

# Navigate to the project directory
cd image-type-detector

# Compile
javac ImageTypeDetector.java

# Run
java ImageTypeDetector <path-to-your-image-file>
```

## 📚 What I Learned

- How popular image formats (JPEG, PNG, GIF, BMP, TIFF) structure their binary data
- Reading and interpreting raw bytes in Java
- Understanding multimedia file format specifications
- Building detection logic based on international format standards

---

> **Course:** Introduction to Multimedia — Alexandria University
