# Three distinct points are plotted at random on a Cartesian plane, for which - 1000 ≤ x, y ≤ 1000, such that a triangle is formed.
# Consider the following two triangles:
# A(-340, 495), B(-153, -910), C (835, -947)
# X (-175,41), Y (-421, -714), Z(574, -645)
# It can be verified that triangle ABC contains the origin, whereas triangle XYZ does not.
# Using triangles.txt (right click and 'Save Link/Target As...'), a 27K text file containing the co-ordinates of one thousand "random" triangles, find the number of triangles for which the interior contains the origin.

def is_origin_inside_triangle(ax, ay, bx, by, cx, cy):
    # Check if the origin is on the same side of each edge of the triangle
    # If the origin is on the same side for all edges, it lies inside the triangle
    def is_same_side(p, a, b, c):
        cp1 = (c[0]-b[0]) * (p[1]-b[1]) - (c[1]-b[1]) * (p[0]-b[0])
        cp2 = (c[0]-b[0]) * (a[1]-b[1]) - (c[1]-b[1]) * (a[0]-b[0])
        return cp1 * cp2 > 0

    
    origin = (0, 0)
    # Check for each vertex
    same_side_ab = is_same_side(origin, (ax, ay), (bx, by), (cx, cy))
    same_side_bc = is_same_side(origin, (bx, by), (ax, ay), (cx, cy))
    same_side_ca = is_same_side(origin, (cx, cy), (ax, ay), (bx, by))
    
    return same_side_ab and same_side_bc and same_side_ca

def main():
    count = 0
    with open("Java/Geometry/triangles.txt", "r") as file:
        for line in file:
            coordinates = list(map(int, line.strip().split(",")))
            ax, ay, bx, by, cx, cy = coordinates
            if is_origin_inside_triangle(ax, ay, bx, by, cx, cy):
                count += 1
    print("Number of triangles containing the origin:", count)

if __name__ == "__main__":
    main()

